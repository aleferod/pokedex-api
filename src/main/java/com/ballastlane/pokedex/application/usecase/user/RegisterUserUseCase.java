package com.ballastlane.pokedex.application.usecase.user;

import com.ballastlane.pokedex.application.port.in.user.RegisterUser;
import com.ballastlane.pokedex.application.port.in.user.RegisterUserCommand;
import com.ballastlane.pokedex.application.port.out.user.PasswordHasherPort;
import com.ballastlane.pokedex.application.port.out.user.UserRepositoryPort;
import com.ballastlane.pokedex.domain.user.User;
import com.ballastlane.pokedex.domain.user.password.PasswordPolicy;
import java.time.Clock;

/** Registers accounts (stub). */
public class RegisterUserUseCase implements RegisterUser {

  public RegisterUserUseCase(
      UserRepositoryPort users, PasswordHasherPort hasher, PasswordPolicy policy, Clock clock) {}

  @Override
  public User register(RegisterUserCommand command) {
    return null;
  }
}
