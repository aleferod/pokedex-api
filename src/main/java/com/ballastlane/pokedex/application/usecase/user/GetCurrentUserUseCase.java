package com.ballastlane.pokedex.application.usecase.user;

import com.ballastlane.pokedex.application.port.in.user.GetCurrentUser;
import com.ballastlane.pokedex.application.port.out.user.UserRepositoryPort;
import com.ballastlane.pokedex.domain.user.User;
import com.ballastlane.pokedex.domain.user.UserId;

/** Loads the current account (stub). */
public class GetCurrentUserUseCase implements GetCurrentUser {

  public GetCurrentUserUseCase(UserRepositoryPort users) {}

  @Override
  public User byId(UserId id) {
    return null;
  }
}
