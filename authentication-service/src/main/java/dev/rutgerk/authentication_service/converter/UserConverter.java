package dev.rutgerk.authentication_service.converter;

import java.util.List;
import org.springframework.stereotype.Component;
import dev.rutgerk.authentication_service.dto.UserCreationDto;
import dev.rutgerk.authentication_service.dto.UserDto;
import dev.rutgerk.authentication_service.model.User;

@Component
public class UserConverter {

  public UserDto convert(User user, String token) {

    return UserDto.builder().id(user.getId()).roles(user.getRoles()).login(user.getLogin())
        .token(token).build();
  }

  public User convert(UserCreationDto userCreationDto, String passwordHash) {
    return User.builder().login(userCreationDto.getLogin())
        .firstName(userCreationDto.getFirstName()).lastName(userCreationDto.getLastName())
        .passwordEncoded(passwordHash).roles(userCreationDto.getRoles()).build();
  }

  public List<UserDto> convertAll(List<User> users) {
    return users.stream().map(user -> convert(user, null)).toList();
  }

}
