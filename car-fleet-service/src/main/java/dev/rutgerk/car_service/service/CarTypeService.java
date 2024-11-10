package dev.rutgerk.car_service.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import dev.rutgerk.car_service.model.CarType;
import dev.rutgerk.car_service.repository.CarTypeRepository;

@Service
public class CarTypeService {

  private static final Logger LOG = LoggerFactory.getLogger(CarTypeService.class);

  private CarTypeRepository repository;

  public CarTypeService(CarTypeRepository repository) {
    this.repository = repository;
  }

  public List<CarType> findAll() {
    LOG.info("fetching all car types");
    return repository.findAll();
  }

}
