package com.ballastlane.pokedex.adapter.out.cache;

import com.ballastlane.pokedex.application.port.out.pokemon.PokemonCatalogPort;
import com.ballastlane.pokedex.domain.pokemon.PokemonDetail;
import com.ballastlane.pokedex.domain.pokemon.PokemonIdentifier;
import com.ballastlane.pokedex.domain.pokemon.PokemonSummary;
import com.ballastlane.pokedex.domain.shared.Page;
import com.ballastlane.pokedex.domain.shared.PageRequest;
import java.util.Optional;
import org.springframework.cache.Cache;

/** Decorator: caches a {@link PokemonCatalogPort} (stub: passes through). */
public class CachingPokemonCatalog implements PokemonCatalogPort {

  public static final String PAGES = "pokemon-pages";
  public static final String DETAILS = "pokemon-details";

  private final PokemonCatalogPort delegate;

  public CachingPokemonCatalog(PokemonCatalogPort delegate, Cache pages, Cache details) {
    this.delegate = delegate;
  }

  @Override
  public Page<PokemonSummary> findPage(PageRequest request) {
    return delegate.findPage(request);
  }

  @Override
  public Optional<PokemonDetail> findDetail(PokemonIdentifier identifier) {
    return delegate.findDetail(identifier);
  }

  @Override
  public Optional<PokemonDetail> findFreshDetail(PokemonIdentifier identifier) {
    return delegate.findFreshDetail(identifier);
  }
}
