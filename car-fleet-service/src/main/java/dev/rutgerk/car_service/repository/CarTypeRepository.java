package dev.rutgerk.car_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.rutgerk.car_service.model.CarType;


public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}
