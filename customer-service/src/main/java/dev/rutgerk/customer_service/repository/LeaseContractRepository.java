package dev.rutgerk.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.rutgerk.customer_service.model.LeaseContract;


public interface LeaseContractRepository extends JpaRepository<LeaseContract, Long> {
}
