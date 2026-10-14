package com.ballastlane.pokedex.domain.user;

/** UserId (stub). */
public record UserId(java.util.UUID value) {

  public static UserId random() {
    return new UserId(null);
  }

  public static UserId of(String value) {
    return new UserId(null);
  }
}
