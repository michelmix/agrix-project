package com.betrybe.agrix.ebytr.staff.controller;


import com.betrybe.agrix.ebytr.staff.controller.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rota Crops.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {

    this.cropService = cropService;
  }

  @GetMapping
  public List<CropDto> findAll() {
    List<Crop> crops = cropService.getAllCrops();
    return crops.stream().map(CropDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public CropDto findById(@PathVariable Long id) throws CropNotFoundException {
    Crop crop = cropService.findCropById(id);
    return CropDto.fromEntity(crop);
  }

  /**
   * Rota Crops com uma busca customizada baseada no atributo harvestDate da entidade Crop.
   *
   * @param start data de início
   * @param end   data de fim
   * @return uma lista CropDTO
   */
  @GetMapping("/search")
  public List<CropDto> findBySearchedDate(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
    List<Crop> crops = cropService.findHarvestByDate(start, end);
    return crops.stream().map(CropDto::fromEntity).toList();
  }

  /**
   * Rota Post de associação entre crop e fertilizer.

   * @return mensagem de sucesso.

   */
  @PostMapping("{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateCropAndFertilizer(@PathVariable Long cropId,
      @PathVariable Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    String association =  cropService.associateCropAndFertilizer(cropId, fertilizerId);

    return ResponseEntity.status(HttpStatus.CREATED).body(association);
  }

  /**
   * Rota Get fertilizers a partir de um crop.
   */

  @GetMapping("/{cropId}/fertilizers")
  public List<FertilizerDto> findFertilizersByCropId(@PathVariable Long cropId)
      throws CropNotFoundException {

    Crop crop = cropService.findCropById(cropId);
    List<Fertilizer> fertilizers = crop.getFertilizers();

    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }
}
