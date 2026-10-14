package com.ballastlane.pokedex.application.usecase.pokemon;

import com.ballastlane.pokedex.application.port.in.pokemon.ListPokemon;
import com.ballastlane.pokedex.application.port.out.pokemon.PokemonCatalogPort;
import com.ballastlane.pokedex.domain.pokemon.PokemonSummary;
import com.ballastlane.pokedex.domain.shared.Page;
import com.ballastlane.pokedex.domain.shared.PageRequest;

/** Lists the catalog (stub). */
public class ListPokemonUseCase implements ListPokemon {

  public ListPokemonUseCase(PokemonCatalogPort catalog) {}

  @Override
  public Page<PokemonSummary> list(PageRequest request) {
    return null;
  }
}
