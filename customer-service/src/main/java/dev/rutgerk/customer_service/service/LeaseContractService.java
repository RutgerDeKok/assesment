package dev.rutgerk.customer_service.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.stereotype.Service;
import dev.rutgerk.customer_service.converter.LeaseContractConverter;
import dev.rutgerk.customer_service.dto.LeaseContractDto;
import dev.rutgerk.customer_service.model.LeaseContract;
import dev.rutgerk.customer_service.repository.LeaseContractRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class LeaseContractService {

  private static final int MONTH_PER_YEAR = 12;
  private static final MathContext TEN_DECIMALS = new MathContext(10);
  private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100L);

  private final LeaseContractRepository repository;
  private final LeaseContractConverter converter;


  public List<LeaseContract> findAll() {
    log.info("fetching all lease contracts");
    return repository.findAll();
  }


  /**
   * Calculates the lease rate based on the values provided in the LeaseRateRequestDto using the
   * following formula:
   * 
   * (( duration * mileage / 12 ) / Nett price) + (( Nett price * Interest rate / 100 ) / 12)
   * 
   * @param LeaseContractDto
   * @return lease rate per month
   */
  public BigDecimal calculateLeaseRate(LeaseContractDto request) throws IllegalArgumentException {

    var priceNett = request.getPriceNett();
    var interestRate = request.getInterestRate();

    if (priceNett == null || interestRate == null) {
      throw new IllegalArgumentException("values can not be empty!");
    }

    // ( duration * mileage / 12 )
    int totalDistance = request.getDurationMonths() * request.getMileagePerYear() / MONTH_PER_YEAR;

    // ( duration * mileage / 12 ) / Nett price)
    var pricePerMile = BigDecimal.valueOf(totalDistance).divide(priceNett, TEN_DECIMALS);

    // ( Nett price * Interest rate / 100 )
    var interest = priceNett.multiply(request.getInterestRate()).divide(ONE_HUNDRED, TEN_DECIMALS);

    // (( Nett price * Interest rate / 100 ) / 12)
    var interestPerMonth = interest.divide(BigDecimal.valueOf(MONTH_PER_YEAR), TEN_DECIMALS);

    // (( duration * mileage / 12 ) / Nett price) + (( Nett price * Interest rate / 100 ) / 12)
    return pricePerMile.add(interestPerMonth).setScale(2, RoundingMode.HALF_UP);
  }


  /**
   * Find lease contracts by customer id. Returns empty list if none are found.
   * 
   * @param customerId
   * @return List<LeaseContract>
   */
  public List<LeaseContract> findByCustomerId(long customerId) {
    return repository.findByCustomerId(customerId);
  }


  /**
   * Converts the supplied LeaseContractDto to a LeaseContract and persists it. The new id is set in
   * the LeaseContractDto which is returned;
   * 
   * @param leaseContractDto
   * @return LeaseContractDto
   */
  public LeaseContractDto createLeaseContract(LeaseContractDto leaseContractDto) {
    LeaseContract leaseContract = converter.convert(leaseContractDto);
    leaseContract = repository.save(leaseContract);
    leaseContractDto.setId(leaseContract.getId());
    return leaseContractDto;
  }


}
