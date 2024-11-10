package dev.rutgerk.car_service.application;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"dev.rutgerk.car_service", "dev.rutgerk.car_service.model"})
public class CarServiceApplication implements ApplicationListener<ContextRefreshedEvent> {

  private static final Logger LOG = LoggerFactory.getLogger(CarServiceApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CarServiceApplication.class, args);
  }

  /**
   * This method will display the available rest endpoints on startup.
   */
  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    ApplicationContext applicationContext = (event).getApplicationContext();
    RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
        .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
    Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
    map.forEach((key, value) -> LOG.info("{} {}", key, value));
  }

}
