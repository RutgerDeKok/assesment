package dev.rutgerk.customer_service.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.customer_service.model.LeaseContract;
import dev.rutgerk.customer_service.service.LeaseContractService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/lease-contract")
public class LeaseContractController {

  private LeaseContractService leaseContractService;

  public LeaseContractController(LeaseContractService leaseContractService) {
    this.leaseContractService = leaseContractService;
  }


  @GetMapping
  List<LeaseContract> findAll() {
    log.info("fetching all lease contracts");
    return leaseContractService.findAll();
  }

}
