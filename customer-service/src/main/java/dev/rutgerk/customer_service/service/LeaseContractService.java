package dev.rutgerk.customer_service.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;
import dev.rutgerk.customer_service.dto.LeaseRateRequestDto;
import dev.rutgerk.customer_service.model.LeaseContract;
import dev.rutgerk.customer_service.repository.LeaseContractRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LeaseContractService {

  private static final int MONTH_PER_YEAR = 12;
  private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100L);

  private LeaseContractRepository repository;

  public LeaseContractService(LeaseContractRepository repository) {
    this.repository = repository;
  }

  public List<LeaseContract> findAll() {
    log.info("fetching all lease contracts");
    return repository.findAll();
  }


  /**
   * Calculates the lease rate based on the values provided in the LeaseRateRequestDto using the
   * following formula:
   * 
   * ((( mileage / 12 )*duration )/Nett price) + ((( Interest rate / 100 ) * Nett * price) / 12)
   * 
   * @param LeaseRateRequest
   * @return lease rate per month
   */
  public BigDecimal calculateLeaseRate(LeaseRateRequestDto leaseRateRequest)
      throws IllegalArgumentException {

    int totalMiles = leaseRateRequest.getMileagePerYear() / MONTH_PER_YEAR
        * leaseRateRequest.getDurationMonths();

    BigDecimal priceNett = leaseRateRequest.getPriceNett();
    try {
      BigDecimal pricePerMile =
          BigDecimal.valueOf(totalMiles).divide(priceNett, 4, RoundingMode.HALF_UP);
      BigDecimal interest = leaseRateRequest.getInterestRate()
          .divide(ONE_HUNDRED, 4, RoundingMode.HALF_UP).multiply(priceNett);
      BigDecimal interestPerMonth =
          interest.divide(BigDecimal.valueOf(MONTH_PER_YEAR), 4, RoundingMode.HALF_UP);
      return pricePerMile.add(interestPerMonth).setScale(2, RoundingMode.HALF_UP);
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }


}
