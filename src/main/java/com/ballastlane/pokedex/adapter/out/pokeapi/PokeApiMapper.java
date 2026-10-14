package com.ballastlane.pokedex.adapter.out.pokeapi;

import com.ballastlane.pokedex.adapter.out.pokeapi.dto.PokemonDto;
import com.ballastlane.pokedex.adapter.out.pokeapi.dto.PokemonSpeciesDto;
import com.ballastlane.pokedex.domain.pokemon.PokemonSummary;

/** Anti-corruption layer (stub). */
final class PokeApiMapper {

  private PokeApiMapper() {}

  static PokemonSummary toSummary(PokemonDto pokemon, PokemonSpeciesDto species) {
    return null;
  }

  static int idFromUrl(String url) {
    return 0;
  }
}
