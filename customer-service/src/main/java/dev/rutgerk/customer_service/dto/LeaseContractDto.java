package dev.rutgerk.customer_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LeaseContractDto {

  private Long id;
  private Long customerId;
  private Long carTypeId;
  private int mileagePerYear;
  private int durationMonths;
  private BigDecimal interestRate;
  private LocalDate startDate;
  private BigDecimal priceNett;
  private BigDecimal rate;

}
