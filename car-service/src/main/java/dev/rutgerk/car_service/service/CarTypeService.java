package dev.rutgerk.car_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.rutgerk.car_service.converter.CarTypeConverter;
import dev.rutgerk.car_service.dto.CarTypeDto;
import dev.rutgerk.car_service.model.CarType;
import dev.rutgerk.car_service.repository.CarTypeRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarTypeService {

  private final CarTypeRepository repository;
  private final CarTypeConverter converter;


  public List<CarTypeDto> findAll() {
    log.info("fetching all car types");
    return converter.convertAllModels(repository.findAll());
  }

  public List<CarTypeDto> findByMake(String make) {
    log.info("fetching all car types by make {}", make);
    return converter.convertAllModels(repository.findByMake(make));
  }

  /**
   * Creates a new CartType from a CarTypeDto and persists it. returns persisted carTypId
   * 
   * @param carTypeDto
   * @return id
   */
  public Long createCarType(CarTypeDto carTypeDto) {
    log.info("creating new car types: {}", carTypeDto.toString());
    CarType carType = converter.convert(carTypeDto);
    carType = repository.save(carType);

    return carType.getId();
  }

  /**
   * Deletes the carType with the given id.
   * <p>
   * If the carType is not found in the persistence store it is silently ignored.
   *
   * @param id must not be {@literal null}.
   * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}
   */
  public Long deleteById(Long id) {
    repository.deleteById(id);
    return id;
  }



  /**
   * get the carType by Id. Throws a NotFoundException when not found
   * 
   * @param id
   * @return CarTypeDto
   */
  public CarTypeDto getById(Long id) {
    CarType carType = findById(id);
    return converter.convert(carType);
  }


  /**
   * Updates an existing carType based on the id. All fields are updated.
   * 
   * Throws a NotFoundException when not found.
   * 
   * @param carTypeDto
   * @return id
   */
  @Transactional
  public Long updateCartType(CarTypeDto carTypeDto) {
    CarType carType = findById(carTypeDto.getId());

    carType.setMake(carType.getMake());
    carType.setModel(carType.getModel());
    carType.setVersion(carType.getVersion());
    carType.setNumberOfDoors(carType.getNumberOfDoors());
    carType.setCo2Emission(carType.getCo2Emission());
    carType.setPriceGross(carType.getPriceGross());
    carType.setPriceNett(carType.getPriceNett());

    return repository.save(carType).getId();
  }



  private CarType findById(Long id) {
    return repository.findById(id).orElseThrow(NotFoundException::new);
  }



}
