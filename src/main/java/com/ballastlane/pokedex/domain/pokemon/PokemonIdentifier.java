package com.ballastlane.pokedex.domain.pokemon;

/** How a client names a Pokémon (stub: no validation yet). */
public sealed interface PokemonIdentifier permits PokemonIdentifier.ById, PokemonIdentifier.ByName {

  static PokemonIdentifier parse(String raw) {
    return new ByName(raw);
  }

  String value();

  /** By Pokédex number. */
  record ById(PokemonId id) implements PokemonIdentifier {
    @Override
    public String value() {
      return "";
    }
  }

  /** By name. */
  record ByName(String name) implements PokemonIdentifier {
    @Override
    public String value() {
      return "";
    }
  }
}
