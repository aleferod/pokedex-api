package com.ballastlane.pokedex.domain.localpokemon;

import java.util.Map;

/** Names per locale (stub). */
public record LocalizedNames(Map<String, String> names) {

  public static LocalizedNames empty() {
    return new LocalizedNames(Map.of());
  }

  public static LocalizedNames of(Map<String, String> names) {
    return new LocalizedNames(names);
  }
}
