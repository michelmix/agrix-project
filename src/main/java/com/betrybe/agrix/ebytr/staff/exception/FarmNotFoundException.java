package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Exceção FarmNotFound.
 */

public class FarmNotFoundException extends RuntimeException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
