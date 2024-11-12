package dev.rutgerk.api_gateway.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableDiscoveryClient
// @EnableWebSecurity
@ComponentScan(basePackages = {"dev.rutgerk.api_gateway"})
public class ApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiGatewayApplication.class, args);
  }

  // /**
  // * Dit is een tijdelijke methode die het makkelijker maakt om met een lokaal html projectje test
  // * uit te voeren zonder cors exceptions
  // *
  // * @return
  // */
  // @Bean
  // public WebMvcConfigurer corsConfigurer() {
  // return new WebMvcConfigurer() {
  // @Override
  // public void addCorsMappings(CorsRegistry registry) {
  // registry.addMapping("/**").allowedOrigins("*");
  // }
  // };
  // }

}
