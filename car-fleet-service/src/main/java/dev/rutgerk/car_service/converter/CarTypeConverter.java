package dev.rutgerk.car_service.converter;

import java.util.List;
import org.springframework.stereotype.Component;
import dev.rutgerk.car_service.dto.CarTypeDto;
import dev.rutgerk.car_service.model.CarType;

@Component
public class CarTypeConverter {

  public CarTypeDto convert(CarType carType) {
    return CarTypeDto.builder().id(carType.getId()).make(carType.getMake())
        .model(carType.getModel()).version(carType.getVersion())
        .numberOfDoors(carType.getNumberOfDoors()).co2Emission(carType.getCo2Emission())
        .priceGross(carType.getPriceGross()).priceNett(carType.getPriceNett()).build();
  }

  public CarType convert(CarTypeDto carTypeDto) {
    return CarType.builder().id(carTypeDto.getId()).make(carTypeDto.getMake())
        .model(carTypeDto.getModel()).version(carTypeDto.getVersion())
        .numberOfDoors(carTypeDto.getNumberOfDoors()).co2Emission(carTypeDto.getCo2Emission())
        .priceGross(carTypeDto.getPriceGross()).priceNett(carTypeDto.getPriceNett()).build();
  }

  public List<CarTypeDto> convertAllModels(List<CarType> carTypes) {
    return carTypes.stream().map(this::convert).toList();
  }

  public List<CarType> convertAllDtos(List<CarTypeDto> carTypesDtos) {
    return carTypesDtos.stream().map(this::convert).toList();
  }

}
