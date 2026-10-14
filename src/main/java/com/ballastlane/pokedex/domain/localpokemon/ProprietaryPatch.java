package com.ballastlane.pokedex.domain.localpokemon;

import java.util.List;

/** A JSON-merge-patch of the proprietary fields (stub). */
public record ProprietaryPatch(
    LocalizedNamesPatch localizedNames,
    FieldPatch<String> region,
    FieldPatch<String> habitatNotes,
    FieldPatch<List<String>> internalTags,
    FieldPatch<String> notes) {

  public ProprietaryData applyTo(ProprietaryData current) {
    return current;
  }
}
