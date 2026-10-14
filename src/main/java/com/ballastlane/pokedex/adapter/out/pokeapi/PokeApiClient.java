package com.ballastlane.pokedex.adapter.out.pokeapi;

import com.ballastlane.pokedex.adapter.out.pokeapi.dto.PokemonDto;
import com.ballastlane.pokedex.adapter.out.pokeapi.dto.PokemonSpeciesDto;
import com.ballastlane.pokedex.adapter.out.pokeapi.dto.ResourceListDto;
import java.time.Duration;

/** PokeAPI HTTP client (stub). */
public final class PokeApiClient {

  private PokeApiClient() {}

  public static PokeApiClient create(
      String baseUrl, Duration connectTimeout, Duration readTimeout, String userAgent) {
    return new PokeApiClient();
  }

  ResourceListDto listPokemon(long offset, int limit) {
    return null;
  }

  PokemonDto pokemon(int id) {
    return null;
  }

  PokemonSpeciesDto species(int id) {
    return null;
  }
}
