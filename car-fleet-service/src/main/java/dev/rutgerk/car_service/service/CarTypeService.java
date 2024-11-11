package dev.rutgerk.car_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import dev.rutgerk.car_service.model.CarType;
import dev.rutgerk.car_service.repository.CarTypeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CarTypeService {

  private CarTypeRepository repository;

  public CarTypeService(CarTypeRepository repository) {
    this.repository = repository;
  }

  public List<CarType> findAll() {
    log.info("fetching all car types");
    return repository.findAll();
  }

}
