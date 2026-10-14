package com.ballastlane.pokedex.adapter.out.persistence.localpokemon;

import com.ballastlane.pokedex.application.port.out.localpokemon.LocalPokemonRepositoryPort;
import com.ballastlane.pokedex.domain.localpokemon.DuplicateLocalPokemonException;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonFilter;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;
import com.ballastlane.pokedex.domain.localpokemon.StaleLocalPokemonException;
import com.ballastlane.pokedex.domain.pokemon.PokemonId;
import com.ballastlane.pokedex.domain.shared.Page;
import com.ballastlane.pokedex.domain.shared.PageRequest;
import java.util.Locale;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

/**
 * Repository adapter: implements {@link LocalPokemonRepositoryPort} on PostgreSQL. Optimistic
 * locking ({@code @Version}) becomes {@link StaleLocalPokemonException}; the unique PokeAPI number
 * becomes {@link DuplicateLocalPokemonException}. Flushes inside {@link #save} so both surface
 * here.
 */
@Component
public class LocalPokemonPersistenceAdapter implements LocalPokemonRepositoryPort {

  private final SpringDataLocalPokemonRepository repository;

  LocalPokemonPersistenceAdapter(SpringDataLocalPokemonRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<LocalPokemon> findById(LocalPokemonId id) {
    return repository.findById(id.value()).map(LocalPokemonPersistenceMapper::toDomain);
  }

  @Override
  public Optional<LocalPokemon> findByPokeapiId(PokemonId pokeapiId) {
    return repository
        .findByPokeapiId(pokeapiId.value())
        .map(LocalPokemonPersistenceMapper::toDomain);
  }

  @Override
  public LocalPokemon save(LocalPokemon pokemon) {
    try {
      return LocalPokemonPersistenceMapper.toDomain(
          repository.saveAndFlush(LocalPokemonPersistenceMapper.toEntity(pokemon)));
    } catch (OptimisticLockingFailureException stale) {
      throw new StaleLocalPokemonException(pokemon.id());
    } catch (DataIntegrityViolationException violation) {
      String detail =
          String.valueOf(violation.getMostSpecificCause().getMessage()).toLowerCase(Locale.ROOT);
      if (detail.contains("uk_local_pokemon_pokeapi_id")) {
        throw new DuplicateLocalPokemonException(pokemon.pokeapiId());
      }
      throw violation;
    }
  }

  @Override
  public boolean existsByPokeapiId(PokemonId pokeapiId) {
    return false; // stub
  }

  @Override
  public Page<LocalPokemon> findAll(LocalPokemonFilter filter, PageRequest page) {
    return Page.of(java.util.List.of(), page, 0); // stub
  }

  @Override
  public void delete(LocalPokemon pokemon) {
    // stub
  }
}
