package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.ExpectedVersion;
import com.ballastlane.pokedex.application.port.in.localpokemon.PatchLocalPokemon;
import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;
import com.ballastlane.pokedex.domain.localpokemon.ProprietaryPatch;
import java.time.Clock;

/** Stub. */
public class PatchLocalPokemonUseCase implements PatchLocalPokemon {

  private final LocalPokemonRepositoryPort repository;
  private final Clock clock;

  public PatchLocalPokemonUseCase(LocalPokemonRepositoryPort repository, Clock clock) {
    this.repository = repository;
    this.clock = clock;
  }

  @Override
  public LocalPokemon patch(LocalPokemonId id, ExpectedVersion expected, ProprietaryPatch patch) {
    return null;
  }
}
