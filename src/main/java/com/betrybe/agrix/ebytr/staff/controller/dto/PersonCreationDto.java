package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * PersonCreationDto.
 */
public record PersonCreationDto(String username, String password, Role role) {

  /**
   * toEntity: Dto para registrar um nova pessoa no banco de dados.
   */

  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }

}
