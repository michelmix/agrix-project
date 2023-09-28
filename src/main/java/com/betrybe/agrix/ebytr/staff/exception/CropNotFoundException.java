package com.betrybe.agrix.ebytr.staff.exception;

/**
 * Exceção CropNotFound.
 */
public class CropNotFoundException extends RuntimeException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
