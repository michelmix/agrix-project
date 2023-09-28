package com.betrybe.agrix.ebytr.staff.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Entidade Crop.
 */
@Entity
@Table(name = "crops")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farmId;

  private String name;

  @Column(name = "planted_area")
  private Double plantedArea;

  private LocalDate plantedDate;

  private LocalDate harvestDate;

  @ManyToMany
  @JoinTable(
      name = "fertilizer_crop",
      joinColumns = @JoinColumn(name = "crop_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  List<Fertilizer> fertilizers;

  public Crop() {}

  /**
   * Contrutor da entidade Crop.
   */
  public Crop(String name, Double plantedArea, Farm farmId, LocalDate plantedDate,
      LocalDate harvestDate) {
    this.farmId = farmId;
    this.name = name;
    this.plantedArea = plantedArea;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Farm getFarmId() {
    return farmId;
  }

  public void setFarmId(Farm farmId) {
    this.farmId = farmId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }

  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public List<Fertilizer> getFertilizers() {
    return fertilizers;
  }

  public void setFertilizers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }
}
