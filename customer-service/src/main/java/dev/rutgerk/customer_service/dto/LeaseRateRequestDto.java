package dev.rutgerk.customer_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LeaseRateRequestDto {

  private Long id;
  private Long customerId;
  private Long carTypeId;
  private int mileagePerYear;
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

  public int getMileagePerYear() {
    return mileagePerYear;
  }

  public void setMileagePerYear(int mileagePerYear) {
    this.mileagePerYear = mileagePerYear;
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

  public static class Builder {

    private Long id;
    private Long customerId;
    private Long carTypeId;
    private int mileagePerYear;
    private int durationMonths;
    private BigDecimal interestRate;
    private LocalDate startDate;
    private BigDecimal priceNett;

    public Builder() {}

    Builder(Long id, Long customerId, Long carTypeId, int mileagePerYear, int durationMonths,
        BigDecimal interestRate, LocalDate startDate, BigDecimal priceNett) {
      this.id = id;
      this.customerId = customerId;
      this.carTypeId = carTypeId;
      this.mileagePerYear = mileagePerYear;
      this.durationMonths = durationMonths;
      this.interestRate = interestRate;
      this.startDate = startDate;
      this.priceNett = priceNett;
    }

    public Builder id(Long id) {
      this.id = id;
      return Builder.this;
    }

    public Builder customerId(Long customerId) {
      this.customerId = customerId;
      return Builder.this;
    }

    public Builder carTypeId(Long carTypeId) {
      this.carTypeId = carTypeId;
      return Builder.this;
    }

    public Builder mileagePerYear(int mileagePerYear) {
      this.mileagePerYear = mileagePerYear;
      return Builder.this;
    }

    public Builder durationMonths(int durationMonths) {
      this.durationMonths = durationMonths;
      return Builder.this;
    }

    public Builder interestRate(BigDecimal interestRate) {
      this.interestRate = interestRate;
      return Builder.this;
    }

    public Builder startDate(LocalDate startDate) {
      this.startDate = startDate;
      return Builder.this;
    }

    public Builder priceNett(BigDecimal priceNett) {
      this.priceNett = priceNett;
      return Builder.this;
    }

    public LeaseRateRequestDto build() {
      LeaseRateRequestDto leaseRateRequestDto = new LeaseRateRequestDto();
      leaseRateRequestDto.setId(this.id);
      leaseRateRequestDto.setCustomerId(this.customerId);
      leaseRateRequestDto.setCarTypeId(this.carTypeId);
      leaseRateRequestDto.setMileagePerYear(this.mileagePerYear);
      leaseRateRequestDto.setDurationMonths(this.durationMonths);
      leaseRateRequestDto.setInterestRate(this.interestRate);
      leaseRateRequestDto.setStartDate(this.startDate);
      leaseRateRequestDto.setPriceNett(this.priceNett);
      return leaseRateRequestDto;
    }

  }
}
