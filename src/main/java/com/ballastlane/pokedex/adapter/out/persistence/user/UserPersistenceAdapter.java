package com.ballastlane.pokedex.adapter.out.persistence.user;

import com.ballastlane.pokedex.application.port.out.user.UserRepositoryPort;
import com.ballastlane.pokedex.domain.user.EmailAddress;
import com.ballastlane.pokedex.domain.user.User;
import com.ballastlane.pokedex.domain.user.UserId;
import com.ballastlane.pokedex.domain.user.Username;
import java.util.Optional;
import org.springframework.stereotype.Component;

/** Stores accounts in PostgreSQL (stub). */
@Component
public class UserPersistenceAdapter implements UserRepositoryPort {

  @Override
  public boolean existsByUsername(Username username) {
    return false;
  }

  @Override
  public boolean existsByEmail(EmailAddress email) {
    return false;
  }

  @Override
  public Optional<User> findByUsername(Username username) {
    return Optional.empty();
  }

  @Override
  public Optional<User> findById(UserId id) {
    return Optional.empty();
  }

  @Override
  public User save(User user) {
    return user;
  }
}
