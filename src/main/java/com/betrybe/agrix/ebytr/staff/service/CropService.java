package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CropService.
 */

@Service
public class CropService {

  private final CropRepository cropRepository;

  private final FertilizerService fertilizerService;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Método createCrop.
   */

  public Crop createCrop(Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Método findAllCrops.
   */

  public List<Crop> getAllCrops() {
    return cropRepository.findAll();
  }

  /**
   * Método findCropById de Crops.
   */
  public Crop findCropById(Long id) throws CropNotFoundException {
    return cropRepository
        .findById(id)
        .orElseThrow(CropNotFoundException::new);
  }

  public List<Crop> findHarvestByDate(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * Método associateCropAndFertilizer de Crops.
   */

  public String associateCropAndFertilizer(Long cropId, Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = findCropById(cropId);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);

    crop.getFertilizers().add(fertilizer);
    createCrop(crop);

    return "Fertilizante e plantação associados com sucesso!";
  }
}
