package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.ListLocalPokemon;
import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonFilter;
import com.ballastlane.pokedex.domain.shared.Page;
import com.ballastlane.pokedex.domain.shared.PageRequest;

/** Stub. */
public class ListLocalPokemonUseCase implements ListLocalPokemon {

  private final LocalPokemonRepositoryPort repository;

  public ListLocalPokemonUseCase(LocalPokemonRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public Page<LocalPokemon> list(LocalPokemonFilter filter, PageRequest page) {
    return null;
  }
}
