package dev.rutgerk.customer_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.rutgerk.customer_service.converter.CustomerConverter;
import dev.rutgerk.customer_service.dto.CustomerDto;
import dev.rutgerk.customer_service.model.Customer;
import dev.rutgerk.customer_service.repository.CustomerRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerService {

  private final CustomerRepository repository;
  private final CustomerConverter converter;

  public CustomerService(CustomerRepository repository, CustomerConverter converter) {
    this.repository = repository;
    this.converter = converter;
  }

  public List<CustomerDto> findAll() {
    log.info("fetching all customers");
    return converter.convertAllModels(repository.findAll());
  }

  public CustomerDto findByFirstAndLastName(String firstName, String lastName) {
    log.info("find customer by firstName: {} and lastName: {}", firstName, lastName);
    Customer customer = repository.findFirstByFirstAndLastName(firstName, lastName)
        .orElseThrow(NotFoundException::new);
    return converter.convert(customer);
  }

  /**
   * Creates a new Customer from a CustomerDto and persists it. returns customerId
   * 
   * @param customerDto
   * @return id
   */
  public Long createCustomer(CustomerDto customerDto) {
    log.info("creating new customer: {}", customerDto.toString());
    Customer customer = converter.convert(customerDto);
    repository.save(customer);
    return customer.getId();
  }


  /**
   * Updates an existing customer based on the id. All fields are updated.
   * 
   * Throws a NotFoundException when not found.
   * 
   * @param customerDto
   * @return id
   */
  @Transactional
  public Long updateCustomer(CustomerDto customerDto) {
    Customer customer = findById(customerDto.getId());

    customer.setId(customerDto.getId());
    customer.setFirstName(customerDto.getFirstName());
    customer.setLastName(customerDto.getLastName());
    customer.setStreet(customerDto.getStreet());
    customer.setHouseNumber(customerDto.getHouseNumber());
    customer.setZipCode(customerDto.getZipCode());
    customer.setCity(customerDto.getCity());
    customer.setEmailAddress(customerDto.getEmailAddress());
    customer.setPhoneNumber(customerDto.getPhoneNumber());

    return repository.save(customer).getId();
  }



  /**
   * get the customer by Id. Throws a NotFoundException when not found
   * 
   * @param id
   * @return CarTypeDto
   */
  public CustomerDto getById(Long id) {
    Customer customer = findById(id);
    return converter.convert(customer);
  }


  /**
   * Deletes the customer with the given id.
   * <p>
   * If the customer is not found in the persistence store it is silently ignored.
   *
   * @param id must not be {@literal null}.
   * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}
   */
  public Long deleteById(Long id) {
    repository.deleteById(id);
    return id;
  }

  private Customer findById(Long id) {
    return repository.findById(id).orElseThrow(NotFoundException::new);
  }
}
