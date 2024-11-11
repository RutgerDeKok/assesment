package dev.rutgerk.customer_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import dev.rutgerk.customer_service.TestConfig;
import dev.rutgerk.customer_service.dto.LeaseRateRequestDto;
import dev.rutgerk.customer_service.repository.LeaseContractRepository;

@SpringBootTest(classes = TestConfig.class)
class LeaseContractServiceTest {



  @InjectMocks
  private LeaseContractService leaseContractService;


  @Mock
  private LeaseContractRepository repository;

  @BeforeEach
  void setup() {
    leaseContractService = new LeaseContractService(repository);
  }

  @Test
  void calculateLeaseRateTest_missingArgument() {
    LeaseRateRequestDto leaseRateRequestDto =
        new LeaseRateRequestDto.Builder().mileagePerYear(45000).durationMonths(60)
            .interestRate(null).priceNett(new BigDecimal("63000.00")).build();

    final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> leaseContractService.calculateLeaseRate(leaseRateRequestDto));
    System.out.println(exception.getMessage());
    assertEquals(
        "Cannot invoke \"java.math.BigDecimal.divide(java.math.BigDecimal, int, java.math.RoundingMode)\" because the return value of \"dev.rutgerk.customer_service.dto.LeaseRateRequestDto.getInterestRate()\" is null",
        exception.getMessage());
  }

  @Test
  void calculateLeaseRateTest_missingArgument2() {
    LeaseRateRequestDto leaseRateRequestDto =
        new LeaseRateRequestDto.Builder().mileagePerYear(45000).durationMonths(60)
            .interestRate(new BigDecimal("4.5")).priceNett(null).build();

    final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> leaseContractService.calculateLeaseRate(leaseRateRequestDto));
    System.out.println(exception.getMessage());
    assertEquals("Cannot read field \"intCompact\" because \"divisor\" is null",
        exception.getMessage());
  }

  @Test
  void calculateLeaseRateTest_allArgumentsPassed() {
    LeaseRateRequestDto leaseRateRequestDto =
        new LeaseRateRequestDto.Builder().mileagePerYear(45000).durationMonths(60)
            .interestRate(new BigDecimal("4.5")).priceNett(new BigDecimal("63000.00")).build();

    BigDecimal result = leaseContractService.calculateLeaseRate(leaseRateRequestDto);

    assertEquals("239.82", result.toString());
  }

}