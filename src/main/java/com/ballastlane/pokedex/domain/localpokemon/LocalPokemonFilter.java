package com.ballastlane.pokedex.domain.localpokemon;

/**
 * Value object: which local records a listing wants (stub). Both criteria are optional and combine.
 */
public record LocalPokemonFilter(String tag, String name) {

  public static LocalPokemonFilter none() {
    return new LocalPokemonFilter(null, null);
  }
}
