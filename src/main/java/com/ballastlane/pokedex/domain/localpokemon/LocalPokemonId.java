package com.ballastlane.pokedex.domain.localpokemon;

import java.util.UUID;

/** Identity of a local record (stub). */
public record LocalPokemonId(UUID value) {

  public static LocalPokemonId random() {
    return new LocalPokemonId(UUID.randomUUID());
  }

  public static LocalPokemonId parse(String value) {
    return new LocalPokemonId(null);
  }
}
