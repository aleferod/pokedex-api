package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.DeleteLocalPokemon;
import com.ballastlane.pokedex.application.port.in.localpokemon.ExpectedVersion;
import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;

/** Stub. */
public class DeleteLocalPokemonUseCase implements DeleteLocalPokemon {

  private final LocalPokemonRepositoryPort repository;

  public DeleteLocalPokemonUseCase(LocalPokemonRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public void delete(LocalPokemonId id, ExpectedVersion expected) {}
}
