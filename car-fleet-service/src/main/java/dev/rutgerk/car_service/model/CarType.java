package dev.rutgerk.car_service.model;


import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_types")
public class CarType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String make;
  private String model;
  private String version;
  private int numberOfDoors;
  private int co2Emission;
  private BigDecimal priceGross;
  private BigDecimal priceNett;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public int getNumberOfDoors() {
    return numberOfDoors;
  }

  public void setNumberOfDoors(int numberOfDoors) {
    this.numberOfDoors = numberOfDoors;
  }

  public int getCo2Emission() {
    return co2Emission;
  }

  public void setCo2Emission(int co2Emission) {
    this.co2Emission = co2Emission;
  }

  public BigDecimal getPriceGross() {
    return priceGross;
  }

  public void setPriceGross(BigDecimal priceGross) {
    this.priceGross = priceGross;
  }

  public BigDecimal getPriceNett() {
    return priceNett;
  }

  public void setPriceNett(BigDecimal priceNett) {
    this.priceNett = priceNett;
  }



}
