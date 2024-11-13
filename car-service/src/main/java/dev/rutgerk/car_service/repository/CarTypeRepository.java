package dev.rutgerk.car_service.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.rutgerk.car_service.model.CarType;


public interface CarTypeRepository extends JpaRepository<CarType, Long> {

  List<CarType> findByMake(String make);
}
