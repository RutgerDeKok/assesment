package dev.rutgerk.car_service.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.car_service.model.CarType;
import dev.rutgerk.car_service.service.CarTypeService;


@RestController
@RequestMapping("/car-type")
public class CarTypeController {


  private CarTypeService carTypeService;

  public CarTypeController(CarTypeService carTypeService) {
    this.carTypeService = carTypeService;
  }


  @GetMapping
  public List<CarType> findAll() {
    return carTypeService.findAll();
  }

}
