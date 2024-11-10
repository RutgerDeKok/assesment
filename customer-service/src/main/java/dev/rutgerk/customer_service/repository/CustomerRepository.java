package dev.rutgerk.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.rutgerk.customer_service.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
