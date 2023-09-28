package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Exceção FarmNotFound.
 */

public class FertilizerNotFoundException extends RuntimeException {

  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
