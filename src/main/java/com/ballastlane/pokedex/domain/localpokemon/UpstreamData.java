package com.ballastlane.pokedex.domain.localpokemon;

import com.ballastlane.pokedex.domain.pokemon.BaseStats;
import com.ballastlane.pokedex.domain.pokemon.Height;
import com.ballastlane.pokedex.domain.pokemon.Weight;
import java.util.List;

/** Snapshot of the PokeAPI fields kept locally (stub). */
public record UpstreamData(
    String name,
    String spriteUrl,
    String imageUrl,
    String category,
    List<String> types,
    Height height,
    Weight weight,
    List<String> abilities,
    BaseStats stats) {}
