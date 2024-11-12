package dev.rutgerk.authentication_service.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.rutgerk.authentication_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByLogin(String login);

}
