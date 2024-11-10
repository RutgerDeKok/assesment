package dev.rutgerk.customer_service.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lease_contracts")
public class LeaseContract {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long customerId;
  private Long carTypeId;
  private int mileAgePerYear;
  private int durationMonths;
  private BigDecimal interestRate;
  private LocalDate startDate;
  private BigDecimal priceNett;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getCarTypeId() {
    return carTypeId;
  }

  public void setCarTypeId(Long carTypeId) {
    this.carTypeId = carTypeId;
  }

  public int getMileAgePerYear() {
    return mileAgePerYear;
  }

  public void setMileAgePerYear(int mileAgePerYear) {
    this.mileAgePerYear = mileAgePerYear;
  }

  public int getDurationMonths() {
    return durationMonths;
  }

  public void setDurationMonths(int durationMonths) {
    this.durationMonths = durationMonths;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public BigDecimal getPriceNett() {
    return priceNett;
  }

  public void setPriceNett(BigDecimal priceNett) {
    this.priceNett = priceNett;
  }


}
