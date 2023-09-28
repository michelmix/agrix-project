package com.betrybe.agrix.ebytr.staff.controller.advice;

import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controlador de exceções.
 */

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler({FarmNotFoundException.class, CropNotFoundException.class,
      FertilizerNotFoundException.class})
  public ResponseEntity<String> handleNotFound(Exception exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}

