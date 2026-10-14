package com.ballastlane.pokedex.domain.localpokemon;

import java.util.Collection;
import java.util.List;

/** Internal classification tags (stub). */
public record InternalTags(List<String> tags) {

  public static InternalTags empty() {
    return new InternalTags(List.of());
  }

  public static InternalTags of(Collection<String> tags) {
    return new InternalTags(List.copyOf(tags));
  }

  public boolean contains(String tag) {
    return false;
  }
}
