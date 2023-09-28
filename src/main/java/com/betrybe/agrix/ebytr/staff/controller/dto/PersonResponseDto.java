package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * PersonResponseDto.
 */

public record PersonResponseDto(Long id, String username, Role role) {

  /**
   * fromEntity: resposta para o usuário ao registrar uma nova pessoa no banco de dados.
   */
  public static PersonResponseDto fromEntity(Person person) {
    return new PersonResponseDto(
        person.getId(),
        person.getUsername(),
        person.getRole());
  }

}
