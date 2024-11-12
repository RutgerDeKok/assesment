package dev.rutgerk.api_gateway.application;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import dev.rutgerk.api_gateway.client.AuthenticationClient;
import dev.rutgerk.api_gateway.dto.UserDto;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class AuthenticationFilter implements GlobalFilter {

  private RouterValidator validator;
  private AuthenticationClient authenticationClient;


  public AuthenticationFilter(RouterValidator validator,
      AuthenticationClient authenticationClient) {
    this.validator = validator;
    this.authenticationClient = authenticationClient;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    System.out.println("request ontvangen: "); // TODO sysouts verwijderen
    if (validator.isSecured.test(request)) {
      if (authMissing(request)) {
        return onError(exchange, HttpStatus.UNAUTHORIZED);
      }

      final String token = request.getHeaders().getOrEmpty("Authorization").get(0);
      System.out.println("token: " + token);
      ResponseEntity<UserDto> response = authenticationClient.signIn(token);
      if (response.hasBody()) {
        UserDto userDto = response.getBody();
        System.out.println(userDto.getRole());
      } else {
        return onError(exchange, HttpStatus.UNAUTHORIZED);
      }

    }
    return chain.filter(exchange);
  }

  private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
    ServerHttpResponse response = exchange.getResponse();
    response.setStatusCode(httpStatus);
    return response.setComplete();
  }

  private boolean authMissing(ServerHttpRequest request) {
    return !request.getHeaders().containsKey("Authorization");
  }
}
