package com.ballastlane.pokedex.domain.pokemon;

import java.util.List;

/** One stage of an evolution family (stub). */
public record EvolutionStage(
    PokemonId id, String name, String condition, List<EvolutionStage> evolvesTo) {}
