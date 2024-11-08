package dev.rutgerk.car_fleet_service.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarFleetServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarFleetServiceApplication.class, args);
  }

}
