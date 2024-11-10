package dev.rutgerk.customer_service.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.customer_service.model.Customer;
import dev.rutgerk.customer_service.repository.CustomerRepository;



@RestController
@RequestMapping("/api/customer")
public class CustomerController {

  private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

  private CustomerRepository repository;

  public CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }


  @GetMapping
  List<Customer> findAll() {
    LOG.info("fetching all customers");
    return repository.findAll();
  }

}
