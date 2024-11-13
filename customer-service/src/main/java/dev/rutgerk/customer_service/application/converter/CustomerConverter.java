package dev.rutgerk.customer_service.application.converter;

import java.util.List;
import org.springframework.stereotype.Component;
import dev.rutgerk.customer_service.dto.CustomerDto;
import dev.rutgerk.customer_service.model.Customer;

@Component
public class CustomerConverter {

  public CustomerDto convert(Customer customer) {
    return CustomerDto.builder().id(customer.getId()).firstName(customer.getFirstName())
        .lastName(customer.getLastName()).street(customer.getStreet())
        .houseNumber(customer.getHouseNumber()).zipCode(customer.getZipCode())
        .city(customer.getCity()).emailAddress(customer.getEmailAddress())
        .phoneNumber(customer.getPhoneNumber()).build();
  }

  public Customer convert(CustomerDto customerDto) {
    return Customer.builder().id(customerDto.getId()).firstName(customerDto.getFirstName())
        .lastName(customerDto.getLastName()).street(customerDto.getStreet())
        .houseNumber(customerDto.getHouseNumber()).zipCode(customerDto.getZipCode())
        .city(customerDto.getCity()).emailAddress(customerDto.getEmailAddress())
        .phoneNumber(customerDto.getPhoneNumber()).build();
  }

  public List<CustomerDto> convertAllModels(List<Customer> customers) {
    return customers.stream().map(this::convert).toList();
  }

  public List<Customer> convertAllDtos(List<CustomerDto> customersDtos) {
    return customersDtos.stream().map(this::convert).toList();
  }

}
