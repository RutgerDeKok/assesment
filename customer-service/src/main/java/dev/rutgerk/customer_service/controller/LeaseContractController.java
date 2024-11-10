package dev.rutgerk.customer_service.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.customer_service.model.LeaseContract;
import dev.rutgerk.customer_service.service.LeaseContractService;



@RestController
@RequestMapping("/lease-contract")
public class LeaseContractController {

  private static final Logger LOG = LoggerFactory.getLogger(LeaseContractController.class);

  private LeaseContractService leaseContractService;

  public LeaseContractController(LeaseContractService leaseContractService) {
    this.leaseContractService = leaseContractService;
  }


  @GetMapping
  List<LeaseContract> findAll() {
    return leaseContractService.findAll();
  }

}
