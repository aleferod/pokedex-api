package com.ballastlane.pokedex.domain.localpokemon;

import java.time.Instant;

/** Who created a record and when it last changed or synced. */
public record AuditInfo(Instant createdAt, Instant updatedAt, Instant syncedAt, String createdBy) {}
