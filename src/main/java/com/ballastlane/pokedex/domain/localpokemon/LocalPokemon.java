package com.ballastlane.pokedex.domain.localpokemon;

import com.ballastlane.pokedex.domain.pokemon.PokemonId;
import java.time.Instant;

/** A locally owned Pokémon (stub). */
public record LocalPokemon(
    LocalPokemonId id,
    PokemonId pokeapiId,
    UpstreamData upstream,
    ProprietaryData proprietary,
    AuditInfo audit,
    Long version) {

  public static LocalPokemon importFrom(
      LocalPokemonId id, PokemonId pokeapiId, UpstreamData upstream, String actor, Instant now) {
    return new LocalPokemon(id, pokeapiId, upstream, null, null, null);
  }

  public LocalPokemon resyncWith(UpstreamData newUpstream, Instant now) {
    return this;
  }
}
