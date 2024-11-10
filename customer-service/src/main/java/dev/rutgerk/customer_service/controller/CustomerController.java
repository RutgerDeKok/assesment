package dev.rutgerk.customer_service.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.customer_service.model.Customer;
import dev.rutgerk.customer_service.service.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {


  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }


  @GetMapping
  public List<Customer> findAll() {
    return customerService.findAll();
  }

}
