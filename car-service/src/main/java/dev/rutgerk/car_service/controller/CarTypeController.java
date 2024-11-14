package dev.rutgerk.car_service.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.car_service.dto.CarTypeDto;
import dev.rutgerk.car_service.service.CarTypeService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/car-type")
@RequiredArgsConstructor
public class CarTypeController {

  private final CarTypeService carTypeService;

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @GetMapping
  public List<CarTypeDto> findAll() {
    return carTypeService.findAll();
  }

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @GetMapping("/make")
  public List<CarTypeDto> findByMake(@RequestParam String make) {
    return carTypeService.findByMake(make);
  }

  @PreAuthorize("hasRole('EMPLOYEE')")
  @PostMapping("/new")
  public Long createCarType(@RequestBody CarTypeDto carTypeDto) {
    return carTypeService.createCarType(carTypeDto);
  }

  @PreAuthorize("hasRole('EMPLOYEE')")
  @PutMapping("/")
  public Long updateCartType(@RequestBody CarTypeDto carTypeDto) {
    return carTypeService.updateCartType(carTypeDto);
  }

  @PreAuthorize("hasRole('EMPLOYEE','BROKER')")
  @GetMapping("/{id}")
  public CarTypeDto getById(@PathVariable Long id) {
    return carTypeService.getById(id);
  }

  @PreAuthorize("hasRole('EMPLOYEE')")
  @DeleteMapping("/{id}")
  public Long deleteById(@PathVariable Long id) {
    return carTypeService.deleteById(id);
  }

}
