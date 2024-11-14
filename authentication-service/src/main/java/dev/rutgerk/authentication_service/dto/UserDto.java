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
public class UserDto {

  private long id;
  private String role;
  private String login;
  private String token;

  private Set<Role> roles;

}
