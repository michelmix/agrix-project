package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 *Farm Dto.
 */
public record FarmDto(
    Long id,
    String name,
    Double size
) {

  /**
   * converte da entidade para a resposta da requisição do usuário.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
        farm.getId(),
        farm.getName(),
        farm.getSize()
    );
  }

  /**
   * converte da requisição do usuáriuo para a entidade.
   */
  public Farm toEntity() {
    Farm farm = new Farm();
    farm.setName(name);
    farm.setSize(size);
    return farm;
  }
}
