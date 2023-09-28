package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Camada service de Farm.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  private final CropService cropService;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropService cropService) {
    this.farmRepository = farmRepository;
    this.cropService = cropService;
  }

  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  /**
   * Farm método findById lançando exceção FarmNoutFoundException.
   */

  public Farm findById(Long id) throws FarmNotFoundException {
    return farmRepository
        .findById(id)
        .orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Método createCrop dentro de farm porque temos parâmetros recebidos em farms personalizados.
   */

  public Crop createCrop(Crop crop, Long farmId) throws FarmNotFoundException {
    Farm farm = findById(farmId);

    crop.setFarmId(farm);

    return cropService.createCrop(crop);
  }

  /**
   * Método para retornar todas plantações por farmId.
   * farms/{farmId}/crops
   */
  public List<Crop> getAllCropsByFarm(Long farmId) throws FarmNotFoundException {
    Optional<Farm> farmIdToBeFound = farmRepository.findById(farmId);

    if (farmIdToBeFound.isEmpty()) {
      throw new FarmNotFoundException();
    }

    Farm farmFound = farmIdToBeFound.get();
    return farmFound.getCrops();
  }
}
