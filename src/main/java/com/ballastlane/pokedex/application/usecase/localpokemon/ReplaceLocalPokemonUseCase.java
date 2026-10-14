package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.ExpectedVersion;
import com.ballastlane.pokedex.application.port.in.localpokemon.ProprietaryValues;
import com.ballastlane.pokedex.application.port.in.localpokemon.ReplaceLocalPokemon;
import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;
import java.time.Clock;

/** Stub. */
public class ReplaceLocalPokemonUseCase implements ReplaceLocalPokemon {

  private final LocalPokemonRepositoryPort repository;
  private final Clock clock;

  public ReplaceLocalPokemonUseCase(LocalPokemonRepositoryPort repository, Clock clock) {
    this.repository = repository;
    this.clock = clock;
  }

  @Override
  public LocalPokemon replace(
      LocalPokemonId id, ExpectedVersion expected, ProprietaryValues values) {
    return null;
  }
}
