package com.ballastlane.pokedex.domain.user;

import java.time.Instant;

/** A registered account (stub). */
public record User(
    UserId id,
    Username username,
    EmailAddress email,
    PasswordHash passwordHash,
    Role role,
    Instant createdAt,
    Instant updatedAt) {

  public static User register(
      UserId id, Username username, EmailAddress email, PasswordHash passwordHash, Instant now) {
    return new User(id, username, email, passwordHash, null, null, null);
  }

  public static User restore(
      UserId id,
      Username username,
      EmailAddress email,
      PasswordHash passwordHash,
      Role role,
      Instant createdAt,
      Instant updatedAt) {
    return new User(id, username, email, passwordHash, role, createdAt, updatedAt);
  }
}
