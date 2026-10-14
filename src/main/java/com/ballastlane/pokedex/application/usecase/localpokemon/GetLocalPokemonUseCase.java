package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.GetLocalPokemon;
import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;

/** Read one (stub). */
public class GetLocalPokemonUseCase implements GetLocalPokemon {

  public GetLocalPokemonUseCase(LocalPokemonRepositoryPort repository) {}

  @Override
  public LocalPokemon get(LocalPokemonId id) {
    return null;
  }
}
