package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import dev.rutgerk.authentication_service.dto.RoleDto;
import dev.rutgerk.authentication_service.model.Role;
import dev.rutgerk.authentication_service.repository.RoleRepository;
import dev.rutgerk.authentication_service.security.RoleEnum;
import dev.rutgerk.authentication_service.service.RoleService;

// Chat GPT used to create tests for FindRoles() method
class RoleServiceTest {

  @Mock
  private RoleRepository repository;

  @InjectMocks
  private RoleService roleService;

  private Set<RoleDto> roleDtos;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    RoleDto roleDto1 = new RoleDto(RoleEnum.USER, "user");
    RoleDto roleDto2 = new RoleDto(RoleEnum.EMPLOYEE, "employee");
    RoleDto roleDto3 = new RoleDto(RoleEnum.BROKER, "broker");

    roleDtos = new HashSet<>();
    roleDtos.add(roleDto1);
    roleDtos.add(roleDto2);
    roleDtos.add(roleDto3);
  }


  @Test
  void testFindRoles_FoundRoles() {
    // Setup mock repository responses with RoleEnum
    Role userRole = new Role(1, RoleEnum.USER, "user");
    Role employeeRole = new Role(2, RoleEnum.EMPLOYEE, "employee");

    when(repository.findByName(RoleEnum.USER)).thenReturn(Optional.of(userRole));
    when(repository.findByName(RoleEnum.EMPLOYEE)).thenReturn(Optional.of(employeeRole));
    when(repository.findByName(RoleEnum.BROKER)).thenReturn(Optional.empty()); // No role for BROKER

    // Call the method to test
    Set<Role> foundRoles = roleService.findRoles(roleDtos);

    // Assert that the correct roles are returned
    assertEquals(2, foundRoles.size());
    assertTrue(foundRoles.contains(userRole));
    assertTrue(foundRoles.contains(employeeRole));
    assertFalse(foundRoles.contains(new Role(3, RoleEnum.BROKER, "broker"))); // BROKER role should
                                                                              // not be present
  }

  @Test
  void testFindRoles_NoRolesFound() {
    // Setup mock repository responses with no roles found
    when(repository.findByName(RoleEnum.USER)).thenReturn(Optional.empty());
    when(repository.findByName(RoleEnum.EMPLOYEE)).thenReturn(Optional.empty());
    when(repository.findByName(RoleEnum.BROKER)).thenReturn(Optional.empty());

    // Call the method to test
    Set<Role> foundRoles = roleService.findRoles(roleDtos);

    // Assert that no roles are returned
    assertTrue(foundRoles.isEmpty(), "The returned set should be empty");
  }

  @Test
  void testFindRoles_EmptyRoleDtos() {
    // Call the method with an empty set of RoleDto objects
    Set<RoleDto> emptyRoleDtos = new HashSet<>();

    // Call the method to test
    Set<Role> foundRoles = roleService.findRoles(emptyRoleDtos);

    // Assert that the returned set is empty
    assertTrue(foundRoles.isEmpty(),
        "The returned set should be empty when no RoleDto is provided");
  }

  @Test
  void testFindRoles_PartiallyFoundRoles() {
    // Setup mock repository responses with RoleEnum
    Role userRole = new Role(1, RoleEnum.USER, "user");
    Role employeeRole = new Role(2, RoleEnum.EMPLOYEE, "employee");

    when(repository.findByName(RoleEnum.USER)).thenReturn(Optional.of(userRole));
    when(repository.findByName(RoleEnum.EMPLOYEE)).thenReturn(Optional.empty()); // No role for
                                                                                 // EMPLOYEE
    when(repository.findByName(RoleEnum.BROKER))
        .thenReturn(Optional.of(new Role(3, RoleEnum.BROKER, "broker")));

    // Call the method to test
    Set<Role> foundRoles = roleService.findRoles(roleDtos);

    // Assert that only the roles that were found are returned
    assertEquals(2, foundRoles.size());
    assertTrue(foundRoles.contains(userRole));
    assertTrue(foundRoles.contains(new Role(3, RoleEnum.BROKER, "broker")));
    assertFalse(foundRoles.contains(employeeRole)); // EMPLOYEE role should not be present
  }
}

