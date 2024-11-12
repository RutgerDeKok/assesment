package dev.rutgerk.api_gateway.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import dev.rutgerk.api_gateway.dto.UserDto;

@HttpExchange
public interface AuthenticationClient {

  @GetExchange("/user/validateToken")
  public ResponseEntity<UserDto> signIn(@RequestParam String token);

}

