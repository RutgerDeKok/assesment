package dev.rutgerk.customer_service.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.customer_service.dto.CustomerDto;
import dev.rutgerk.customer_service.model.Customer;
import dev.rutgerk.customer_service.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/customer")
public class CustomerController {


  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @Operation(summary = "Fetch all customers")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Customers found",
      content = {@Content(mediaType = "application/json",
          schema = @Schema(implementation = Customer.class))})})
  @GetMapping
  public List<CustomerDto> findAll() {
    return customerService.findAll();
  }

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @GetMapping("/name")
  public CustomerDto findByFirstAndLastName(@RequestParam("first") String firstName,
      @RequestParam("last") String lastName) {
    return customerService.findByFirstAndLastName(firstName, lastName);
  }

  @PreAuthorize("hasRole('BROKER')")
  @PostMapping("/new")
  public Long createCustomer(@RequestBody CustomerDto customerDto) {
    return customerService.createCustomer(customerDto);
  }

  @PreAuthorize("hasRole('BROKER')")
  @PutMapping("/")
  public Long updateCustomerType(@RequestBody CustomerDto customerDto) {
    return customerService.updateCustomer(customerDto);
  }

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @GetMapping("/{id}")
  public CustomerDto getById(@PathVariable Long id) {
    return customerService.getById(id);
  }

  @PreAuthorize("hasRole('BROKER')")
  @DeleteMapping("/{id}")
  public Long deleteById(@PathVariable Long id) {
    return customerService.deleteById(id);
  }


}
