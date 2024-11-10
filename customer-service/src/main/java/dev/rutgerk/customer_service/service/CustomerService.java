package dev.rutgerk.customer_service.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import dev.rutgerk.customer_service.model.Customer;
import dev.rutgerk.customer_service.repository.CustomerRepository;

@Service
public class CustomerService {

  private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

  private CustomerRepository repository;

  public CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public List<Customer> findAll() {
    LOG.info("fetching all customers");
    return repository.findAll();
  }

}
