package dev.rutgerk.api_gateway.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import dev.rutgerk.api_gateway.client.AuthenticationClient;

@Configuration
public class WebClientConfig {



  @Bean
  AuthenticationClient authenticationClient() {
    RestClient client = RestClient.create("http://localhost:8083");
    // TODO moet via de service-registry bepalen wat het adres is

    HttpServiceProxyFactory factory =
        HttpServiceProxyFactory.builderFor(RestClientAdapter.create(client)).build();
    return factory.createClient(AuthenticationClient.class);
  }

}
