package com.ballastlane.pokedex.domain.localpokemon;

import java.util.Map;
import java.util.Set;

/** Merge-patch of localized names (stub). */
public record LocalizedNamesPatch(boolean clearAll, Map<String, String> put, Set<String> remove) {

  public static LocalizedNamesPatch keep() {
    return new LocalizedNamesPatch(false, Map.of(), Set.of());
  }

  public static LocalizedNamesPatch clear() {
    return new LocalizedNamesPatch(true, Map.of(), Set.of());
  }

  public static LocalizedNamesPatch merge(Map<String, String> put, Set<String> remove) {
    return new LocalizedNamesPatch(false, put, remove);
  }

  public Map<String, String> applyTo(Map<String, String> current) {
    return current;
  }
}
