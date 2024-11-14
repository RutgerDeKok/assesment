package dev.rutgerk.authentication_service.dto;

import java.util.Set;
import dev.rutgerk.authentication_service.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserCreationDto {

  private String firstName;
  private String lastName;
  private String login;
  private char[] password;
  private Set<Role> roles;

}
