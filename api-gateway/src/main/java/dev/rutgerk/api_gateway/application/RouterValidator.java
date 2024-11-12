package dev.rutgerk.api_gateway.application;

import java.util.List;
import java.util.function.Predicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class RouterValidator {

  public static final List<String> openEndpoints = List.of("/user/signIn");

  public Predicate<ServerHttpRequest> isSecured =
      request -> openEndpoints.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));
}
