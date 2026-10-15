package com.ballastlane.pokedex.domain.pokemon;

import java.util.Optional;

/** Value object: part of a Pokémon's name to search the catalog by. */
public record PokemonNameQuery(String value) {

  public static Optional<PokemonNameQuery> parse(String raw) {
    return raw == null ? Optional.empty() : Optional.of(new PokemonNameQuery(raw));
  }

  public boolean matches(String name) {
    return name.equals(value);
  }
}
