package dev.rutgerk.car_service.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;


@OpenAPIDefinition
@Configuration
public class OpenApiConfig {


  @Value("${openApi.serverUrl}")
  String serverUrl;

  @Value("${openApi.apiName}")
  String apiName;

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI().servers(List.of(new Server().url(serverUrl)))
        .info(new Info().title(apiName).version("1.0.0"));
  }
}
