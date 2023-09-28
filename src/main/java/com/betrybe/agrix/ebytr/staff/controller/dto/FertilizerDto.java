package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * FertilizerDTO para converter vindo da identidade e indo para entidade.
 */
public record FertilizerDto(
    Long id,
    String name,
    String brand,
    String composition
) {

  /**
   * converte da entidade para a resposta da requisição do usuário.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition()
    );
  }

  /**
   * converte da requisição do usuáriuo para a entidade.
   */
  public Fertilizer toEntity() {
    Fertilizer fertilizer = new Fertilizer();
    fertilizer.setName(name);
    fertilizer.setBrand(brand);
    fertilizer.setComposition(composition);
    return fertilizer;
  }
}

