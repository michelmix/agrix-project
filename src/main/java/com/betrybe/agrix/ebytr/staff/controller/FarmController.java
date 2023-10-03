package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller com a rota /farms.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto save(@RequestBody FarmDto farm) {
    Farm saveFarm = farmService.create(farm.toEntity());
    return FarmDto.fromEntity(saveFarm);
  }

  /**
   * Rota getAll de farms.
   */

  @Secured({"ROLE_ADMIN", "ROLE_MANAGER", "ROLE_USER"})
  @GetMapping
  public List<FarmDto> findAll() {
    List<Farm> farms = farmService.findAll();
    return farms.stream().map(FarmDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public FarmDto findById(@PathVariable Long id) throws FarmNotFoundException {
    Farm farm = farmService.findById(id);
    return FarmDto.fromEntity(farm);
  }

  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> creatCrop(@RequestBody CropDto crop, @PathVariable Long farmId)
      throws FarmNotFoundException {
    Crop saveCrop = farmService.createCrop(crop.toEntity(), farmId);
    return ResponseEntity.status(HttpStatus.CREATED).body(CropDto.fromEntity(saveCrop));
  }


  /**
   * Rota get {farmId}/crops.
   *
   * @param farmId recebido por Url.
   * @return lista de plantações daquela farmId
   * @throws FarmNotFoundException caso não encontre uma fazenda
   */
  @GetMapping("/{farmId}/crops")
  public List<CropDto> getAllCropsByFarm(@PathVariable Long farmId)
      throws FarmNotFoundException {

    Farm farm = farmService.findById(farmId);

    List<Crop> allCrops = farm.getCrops();
    List<CropDto> allCropsResponse = allCrops.stream().map(
        crop -> new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
            crop.getFarmId().getId(), crop.getPlantedDate(), crop.getHarvestDate())).toList();

    return allCropsResponse;
  }
}
