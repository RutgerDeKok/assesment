package dev.rutgerk.customer_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import dev.rutgerk.customer_service.application.converter.CustomerConverter;
import dev.rutgerk.customer_service.dto.CustomerDto;
import dev.rutgerk.customer_service.repository.CustomerRepository;
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

}
