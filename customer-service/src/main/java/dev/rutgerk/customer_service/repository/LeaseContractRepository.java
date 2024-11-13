package dev.rutgerk.customer_service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.rutgerk.customer_service.model.LeaseContract;


public interface LeaseContractRepository extends JpaRepository<LeaseContract, Long> {

  List<LeaseContract> findByCustomerId(Long customerId);
}
