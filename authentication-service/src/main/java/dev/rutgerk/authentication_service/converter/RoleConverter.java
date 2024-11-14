package dev.rutgerk.authentication_service.converter;

import java.util.Set;
import java.util.stream.Collectors;
import dev.rutgerk.authentication_service.dto.RoleDto;
import dev.rutgerk.authentication_service.model.Role;

public class RoleConverter {

  public RoleDto convert(Role role) {
    return RoleDto.builder().name(role.getName()).description(role.getDescription()).build();
  }


  public Set<RoleDto> convertAll(Set<Role> roles) {
    return roles.stream().map(this::convert).collect(Collectors.toSet());
  }

}
