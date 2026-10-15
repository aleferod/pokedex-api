package com.ballastlane.pokedex.application.usecase.user;

import com.ballastlane.pokedex.application.port.in.user.ProvisionUser;
import com.ballastlane.pokedex.application.port.in.user.ProvisionUserCommand;
import com.ballastlane.pokedex.application.port.out.user.PasswordHasherPort;
import com.ballastlane.pokedex.application.port.out.user.UserRepositoryPort;
import com.ballastlane.pokedex.domain.user.password.PasswordPolicy;
import java.time.Clock;

/** Stub. */
public class ProvisionUserUseCase implements ProvisionUser {

  private final UserRepositoryPort users;
  private final PasswordHasherPort hasher;
  private final PasswordPolicy policy;
  private final Clock clock;

  public ProvisionUserUseCase(
      UserRepositoryPort users, PasswordHasherPort hasher, PasswordPolicy policy, Clock clock) {
    this.users = users;
    this.hasher = hasher;
    this.policy = policy;
    this.clock = clock;
  }

  @Override
  public boolean provision(ProvisionUserCommand command) {
    return false;
  }
}
