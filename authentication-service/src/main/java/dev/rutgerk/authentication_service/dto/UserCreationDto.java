package dev.rutgerk.authentication_service.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class UserCreationDto {

  private String firstName;
  private String lastName;
  private String login;
  private char[] password;

  private Set<RoleDto> roles;

}
