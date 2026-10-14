package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.SyncPokemon;
import com.ballastlane.pokedex.application.port.in.localpokemon.SyncResult;
import com.ballastlane.pokedex.application.port.in.pokemon.GetPokemonDetail;
import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.pokemon.PokemonIdentifier;
import java.time.Clock;

/** Sync (stub). */
public class SyncPokemonUseCase implements SyncPokemon {

  public SyncPokemonUseCase(
      GetPokemonDetail getPokemonDetail, LocalPokemonRepositoryPort repository, Clock clock) {}

  @Override
  public SyncResult sync(PokemonIdentifier identifier, String actor) {
    return null;
  }
}
