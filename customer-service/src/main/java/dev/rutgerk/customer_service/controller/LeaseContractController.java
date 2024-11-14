package dev.rutgerk.customer_service.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.customer_service.dto.LeaseContractDto;
import dev.rutgerk.customer_service.model.LeaseContract;
import dev.rutgerk.customer_service.service.LeaseContractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/lease-contract")
public class LeaseContractController {

  private final LeaseContractService leaseContractService;



  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @GetMapping
  public List<LeaseContract> findAll() {
    log.info("fetching all lease contracts");
    return leaseContractService.findAll();
  }

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @PostMapping("/calculate-rate")
  public BigDecimal calculateLeaseRate(@RequestBody LeaseContractDto request) {
    log.info("calculating lease rate for customer {}", request.getCustomerId());
    return leaseContractService.calculateLeaseRate(request);
  }

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @GetMapping("/customer/{customerId}")
  public List<LeaseContract> findByCustomerId(@PathVariable long customerId) {
    log.info("fetching lease contracts for customer {}", customerId);
    return leaseContractService.findByCustomerId(customerId);
  }

  @PreAuthorize("hasRole('BROKER')")
  @PostMapping
  public LeaseContractDto createLeaseContract(LeaseContractDto leaseContractDto) {
    log.info("Creating new lease contract for customer {}", leaseContractDto.getCustomerId());
    return leaseContractService.createLeaseContract(leaseContractDto);
  }

}
