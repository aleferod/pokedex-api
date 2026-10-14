package com.ballastlane.pokedex.adapter.out.security;

import com.ballastlane.pokedex.application.port.out.user.PasswordHasherPort;
import com.ballastlane.pokedex.domain.user.PasswordHash;

/** BCrypt password hashing (stub). */
public class BCryptPasswordHasher implements PasswordHasherPort {

  public BCryptPasswordHasher(int strength) {}

  @Override
  public PasswordHash hash(String rawPassword) {
    return new PasswordHash(rawPassword);
  }

  @Override
  public boolean matches(String rawPassword, PasswordHash hash) {
    return false;
  }
}
