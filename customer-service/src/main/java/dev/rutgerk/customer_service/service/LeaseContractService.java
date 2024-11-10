package dev.rutgerk.customer_service.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import dev.rutgerk.customer_service.model.LeaseContract;
import dev.rutgerk.customer_service.repository.LeaseContractRepository;

@Service
public class LeaseContractService {

  private static final Logger LOG = LoggerFactory.getLogger(LeaseContractService.class);

  private LeaseContractRepository repository;

  public LeaseContractService(LeaseContractRepository repository) {
    this.repository = repository;
  }

  public List<LeaseContract> findAll() {
    LOG.info("fetching all lease contracts");
    return repository.findAll();
  }

}
