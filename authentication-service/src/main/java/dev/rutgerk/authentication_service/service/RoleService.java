package dev.rutgerk.authentication_service.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import dev.rutgerk.authentication_service.converter.RoleConverter;
import dev.rutgerk.authentication_service.dto.RoleDto;
import dev.rutgerk.authentication_service.model.Role;
import dev.rutgerk.authentication_service.repository.RoleRepository;
import dev.rutgerk.authentication_service.security.RoleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoleService {

  private final RoleConverter converter;
  private final RoleRepository repository;

  public Optional<Role> findByName(RoleEnum name) {
    return repository.findByName(name);
  }

  public Set<RoleDto> convertAll(Set<Role> roles) {
    return converter.convertAll(roles);
  }


  /**
   * This method takes a Set<RoleDTO> and finds matching Roles and returns the found ones in a
   * Set<Role>. RoleDtos that can not be matched with a Role are ignored.
   * 
   * @param roleDtos
   * @return Set of type Role
   */
  public Set<Role> findRoles(Set<RoleDto> roleDtos) {
    return roleDtos.stream().map(role -> repository.findByName(role.getName()))
        .filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());
  }


}
