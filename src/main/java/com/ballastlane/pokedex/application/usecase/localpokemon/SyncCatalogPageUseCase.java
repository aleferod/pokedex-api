package com.ballastlane.pokedex.application.usecase.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.BulkSyncResult;
import com.ballastlane.pokedex.application.port.in.localpokemon.SyncCatalogPage;
import com.ballastlane.pokedex.application.port.in.localpokemon.SyncPokemon;
import com.ballastlane.pokedex.application.port.in.pokemon.ListPokemon;
import java.util.List;

/** Bulk sync (stub). */
public class SyncCatalogPageUseCase implements SyncCatalogPage {

  public SyncCatalogPageUseCase(ListPokemon listPokemon, SyncPokemon syncPokemon) {}

  @Override
  public BulkSyncResult syncFirst(int limit, String actor) {
    return new BulkSyncResult(List.of());
  }
}
