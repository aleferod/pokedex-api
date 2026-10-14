package com.ballastlane.pokedex.domain.pokemon;

import java.math.BigDecimal;

/** Height (stub). */
public record Height(int decimetres) {

  public static Height ofDecimetres(int decimetres) {
    return new Height(decimetres);
  }

  public BigDecimal metres() {
    return BigDecimal.ZERO;
  }
}
