package com.ballastlane.pokedex.application.usecase.user;

import com.ballastlane.pokedex.application.port.in.user.AuthenticateUser;
import com.ballastlane.pokedex.application.port.in.user.AuthenticatedUser;
import com.ballastlane.pokedex.application.port.in.user.Credentials;
import com.ballastlane.pokedex.application.port.out.user.PasswordHasherPort;
import com.ballastlane.pokedex.application.port.out.user.TokenPort;
import com.ballastlane.pokedex.application.port.out.user.UserRepositoryPort;

/** Authenticates accounts (stub). */
public class AuthenticateUserUseCase implements AuthenticateUser {

  public AuthenticateUserUseCase(
      UserRepositoryPort users, PasswordHasherPort hasher, TokenPort tokens) {}

  @Override
  public AuthenticatedUser authenticate(Credentials credentials) {
    return null;
  }
}
