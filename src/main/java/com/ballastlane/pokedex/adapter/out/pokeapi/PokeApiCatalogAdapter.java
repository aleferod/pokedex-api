package com.ballastlane.pokedex.adapter.out.pokeapi;

import com.ballastlane.pokedex.application.port.out.pokemon.PokemonCatalogPort;
import com.ballastlane.pokedex.domain.pokemon.PokemonSummary;
import com.ballastlane.pokedex.domain.shared.Page;
import com.ballastlane.pokedex.domain.shared.PageRequest;
import java.util.List;

/** PokeAPI-backed catalog (stub). */
public class PokeApiCatalogAdapter implements PokemonCatalogPort {

  public PokeApiCatalogAdapter(PokeApiClient client, BoundedFanOut fanOut) {}

  @Override
  public Page<PokemonSummary> findPage(PageRequest request) {
    return Page.of(List.of(), request, 0);
  }
}
