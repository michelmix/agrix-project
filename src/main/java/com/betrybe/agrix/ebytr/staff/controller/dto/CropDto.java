package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * Record de CropDto.
 */

public record CropDto(Long id, String name, Double plantedArea, Long farmId,
                      LocalDate plantedDate, LocalDate harvestDate) {

  /**
   * Método que transforma a entidade Crop em DtoCrop.
   */

  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
        crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getFarmId().getId(),
        crop.getPlantedDate(),
        crop.getHarvestDate()
    );
  }

  /**
   * Método que transforma DtoCrop na entidade Crop.
   */

  public Crop toEntity() {
    Crop crop = new Crop();
    crop.setName(name);
    crop.setPlantedArea(plantedArea);
    crop.setPlantedDate(plantedDate);
    crop.setHarvestDate(harvestDate);
    return crop;
  }
}