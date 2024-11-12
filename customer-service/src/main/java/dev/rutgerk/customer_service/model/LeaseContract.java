package dev.rutgerk.customer_service.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lease_contracts")
public class LeaseContract {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long customerId;
  private Long carTypeId;
  private int mileagePerYear;
  private int durationMonths;
  private BigDecimal interestRate;
  private LocalDate startDate;
  private BigDecimal priceNett;

}
