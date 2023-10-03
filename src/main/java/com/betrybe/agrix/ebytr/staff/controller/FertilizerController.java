package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rota fertilizers.
 */

@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {

    this.fertilizerService = fertilizerService;
  }

  /**
   * Rota Post /fertilizers para criar um ferliziante.S
   */

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto create(@RequestBody FertilizerDto fertilizer) {
    Fertilizer saveFertilizer = fertilizerService.create(fertilizer.toEntity());
    return FertilizerDto.fromEntity(saveFertilizer);
  }

  /**
   * Rota Get /fertilizers para listar todos fertilizantes.
   */

  @Secured("ROLE_ADMIN")
  @GetMapping
  public List<FertilizerDto> findAll() {
    List<Fertilizer> fertilizers = fertilizerService.findAll();

    return fertilizers.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

  /**
   * Rota Get /fertilizers{id} para listar fertilizante por id.
   */

  @GetMapping("/{id}")
  public FertilizerDto findById(@PathVariable Long id) throws FertilizerNotFoundException {
    Fertilizer fertilizer = fertilizerService.findById(id);
    return FertilizerDto.fromEntity(fertilizer);
  }






}
