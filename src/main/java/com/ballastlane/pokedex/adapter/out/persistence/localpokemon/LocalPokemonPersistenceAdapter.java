package com.ballastlane.pokedex.adapter.out.persistence.localpokemon;

import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;
import com.ballastlane.pokedex.domain.pokemon.PokemonId;
import java.util.Optional;
import org.springframework.stereotype.Component;

/** Stores local Pokémon in PostgreSQL (stub). */
@Component
public class LocalPokemonPersistenceAdapter implements LocalPokemonRepositoryPort {

  @Override
  public Optional<LocalPokemon> findById(LocalPokemonId id) {
    return Optional.empty();
  }

  @Override
  public Optional<LocalPokemon> findByPokeapiId(PokemonId pokeapiId) {
    return Optional.empty();
  }

  @Override
  public LocalPokemon save(LocalPokemon pokemon) {
    return pokemon;
  }
}
