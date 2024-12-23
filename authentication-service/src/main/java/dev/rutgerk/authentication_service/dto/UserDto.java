package dev.rutgerk.authentication_service.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private long id;
  private String role;
  private String login;
  private String token;

  private Set<RoleDto> roles;

}
