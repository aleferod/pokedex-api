package com.ballastlane.pokedex.domain.localpokemon;

/** Fields owned by the business (stub). */
public record ProprietaryData(
    LocalizedNames localizedNames,
    String region,
    String habitatNotes,
    InternalTags internalTags,
    String notes) {

  public static ProprietaryData empty() {
    return new ProprietaryData(null, null, null, null, null);
  }
}
