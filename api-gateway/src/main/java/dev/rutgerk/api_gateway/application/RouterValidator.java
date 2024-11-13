package dev.rutgerk.api_gateway.application;

import java.util.List;
import java.util.function.Predicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class RouterValidator {

  // "/v3/api" is part of openAPI urls
  public static final List<String> openEndpoints = List.of("/user/signIn", "/v3/api", "swagger");

  public Predicate<ServerHttpRequest> isSecured =
      request -> openEndpoints.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));
}
