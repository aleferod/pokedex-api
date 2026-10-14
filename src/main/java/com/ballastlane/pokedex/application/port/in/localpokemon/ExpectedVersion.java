package com.ballastlane.pokedex.application.port.in.localpokemon;

import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;

/**
 * The version a client last read ({@code If-Match}), or {@link #any()} when it accepts whatever is
 * stored ({@code If-Match: *}, or a delete without the header).
 */
public record ExpectedVersion(Long value) {

  public static ExpectedVersion any() {
    return new ExpectedVersion(null);
  }

  public static ExpectedVersion exactly(long value) {
    return new ExpectedVersion(value);
  }

  /** Stub. */
  public void verify(LocalPokemon current) {}
}
