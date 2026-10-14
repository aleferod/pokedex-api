package com.ballastlane.pokedex.application.usecase.pokemon;

import com.ballastlane.pokedex.application.port.in.pokemon.GetPokemonDetail;
import com.ballastlane.pokedex.application.port.out.pokemon.PokemonCatalogPort;
import com.ballastlane.pokedex.domain.pokemon.PokemonDetail;
import com.ballastlane.pokedex.domain.pokemon.PokemonIdentifier;

/** Loads one Pokémon's detail (stub). */
public class GetPokemonDetailUseCase implements GetPokemonDetail {

  public GetPokemonDetailUseCase(PokemonCatalogPort catalog) {}

  @Override
  public PokemonDetail get(PokemonIdentifier identifier) {
    return null;
  }
}
