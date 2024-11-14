package dev.rutgerk.authentication_service.dto;

import dev.rutgerk.authentication_service.security.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

  private RoleEnum name;
  private String description;

}
