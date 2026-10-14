package com.ballastlane.pokedex.domain.pokemon;

import java.math.BigDecimal;

/** Weight (stub). */
public record Weight(int hectograms) {

  public static Weight ofHectograms(int hectograms) {
    return new Weight(hectograms);
  }

  public BigDecimal kilograms() {
    return BigDecimal.ZERO;
  }
}
