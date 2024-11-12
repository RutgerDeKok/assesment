package dev.rutgerk.authentication_service.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.rutgerk.authentication_service.dto.CredentialsDto;
import dev.rutgerk.authentication_service.dto.UserCreationDto;
import dev.rutgerk.authentication_service.dto.UserDto;
import dev.rutgerk.authentication_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<UserDto> findAll() {
    return userService.findAll();
  }

  @PostMapping("/signIn")
  public ResponseEntity<UserDto> signIn(@RequestBody CredentialsDto credentialsDto) {
    log.info("Trying to login {}", credentialsDto.getLogin());
    return ResponseEntity.ok(userService.signIn(credentialsDto));
  }

  @PostMapping("/validateToken")
  public ResponseEntity<UserDto> signIn(@RequestParam String token) {
    log.info("Trying to validate token {}", token);
    return ResponseEntity.ok(userService.validateToken(token));
  }

  @PostMapping("/signUp")
  public ResponseEntity<UserDto> signUp(@RequestBody UserCreationDto userCreationDto) {
    log.info("Creating new user {}", userCreationDto.getLogin());
    UserDto user = userService.signUp(userCreationDto);
    // TODO send email
    return ResponseEntity.ok(user);
  }
}
