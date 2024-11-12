package dev.rutgerk.authentication_service.dto;

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
  private String role;

}
