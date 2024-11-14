package dev.rutgerk.authentication_service.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.rutgerk.authentication_service.model.Role;
import dev.rutgerk.authentication_service.security.RoleEnum;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

  Optional<Role> findByName(RoleEnum name);

}
