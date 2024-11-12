package dev.rutgerk.authentication_service.service;


import java.nio.CharBuffer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import dev.rutgerk.authentication_service.converter.UserConverter;
import dev.rutgerk.authentication_service.dto.CredentialsDto;
import dev.rutgerk.authentication_service.dto.UserCreationDto;
import dev.rutgerk.authentication_service.dto.UserDto;
import dev.rutgerk.authentication_service.exception.AppException;
import dev.rutgerk.authentication_service.model.User;
import dev.rutgerk.authentication_service.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserConverter userConverter;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;


  @Value("${jwt.token.secret}")
  private String secret;

  private SecretKey getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(this.secret);
    return Keys.hmacShaKeyFor(keyBytes);
  }


  public UserDto signIn(CredentialsDto credentialsDto) {
    var user = userRepository.findByLogin(credentialsDto.getLogin())
        .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

    if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()),
        user.getPasswordEncoded())) {

      return userConverter.convert(user, createToken(user.getLogin()));
    }

    throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
  }

  public UserDto validateToken(String token) {
    String login = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token)
        .getPayload().getSubject();

    Optional<User> userOptional = userRepository.findByLogin(login);

    if (userOptional.isEmpty()) {
      throw new AppException("User not found", HttpStatus.NOT_FOUND);
    }

    User user = userOptional.get();
    return userConverter.convert(user, createToken(user.getLogin()));
  }

  private String createToken(String userLogin) {
    Map<String, Object> claims = new HashMap<>();

    return Jwts.builder().claims().add(claims).subject(userLogin)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + (60 * 60 * 30L))).and()
        .signWith(getSigningKey()).compact();
  }



  public UserDto signUp(UserCreationDto userCreationDto) {
    log.info("new user {} signing up", userCreationDto.getLogin());
    var userOptional = userRepository.findByLogin(userCreationDto.getLogin());
    if (userOptional.isPresent()) {
      throw new AppException("User already in database", HttpStatus.BAD_REQUEST);
    }

    User user = userConverter.convert(userCreationDto,
        passwordEncoder.encode(CharBuffer.wrap(userCreationDto.getPassword())));

    userRepository.save(user);
    log.info("new user {} saved", userCreationDto.getLogin());
    return UserDto.builder().login(user.getLogin()).build();
  }


  public List<UserDto> findAll() {
    log.info("fetching all users");
    List<User> users = userRepository.findAll();
    return userConverter.convertAll(users);
  }
}
