package com.ballastlane.pokedex.domain.shared;

/** Page request (stub). */
public record PageRequest(int page, int size) {

  public static final int MAX_SIZE = 100;

  public long offset() {
    return 0;
  }
}
