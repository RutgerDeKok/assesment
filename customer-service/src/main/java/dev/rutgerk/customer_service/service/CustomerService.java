package dev.rutgerk.customer_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import dev.rutgerk.customer_service.model.Customer;
import dev.rutgerk.customer_service.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {

  private CustomerRepository repository;

  public CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public List<Customer> findAll() {
    log.info("fetching all customers");
    return repository.findAll();
  }

}
