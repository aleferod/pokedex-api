package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.CreateLocalPokemon;
import com.ballastlane.pokedex.application.port.in.localpokemon.CreateLocalPokemonCommand;
import com.ballastlane.pokedex.application.port.in.pokemon.GetPokemonDetail;
import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import java.time.Clock;

/** Stub. */
public class CreateLocalPokemonUseCase implements CreateLocalPokemon {

  private final GetPokemonDetail getPokemonDetail;
  private final LocalPokemonRepositoryPort repository;
  private final Clock clock;

  public CreateLocalPokemonUseCase(
      GetPokemonDetail getPokemonDetail, LocalPokemonRepositoryPort repository, Clock clock) {
    this.getPokemonDetail = getPokemonDetail;
    this.repository = repository;
    this.clock = clock;
  }

  @Override
  public LocalPokemon create(CreateLocalPokemonCommand command, String actor) {
    return null;
  }
}
