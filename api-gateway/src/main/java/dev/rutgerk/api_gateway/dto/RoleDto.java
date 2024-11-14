package dev.rutgerk.api_gateway.dto;


import dev.rutgerk.api_gateway.security.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

  private RoleEnum name;
  private String description;

}
