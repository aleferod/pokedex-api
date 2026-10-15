package com.ballastlane.pokedex.infrastructure.seed;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** Demo data settings (stub). */
@ConfigurationProperties("app.seed")
public record SeedProperties(Boolean enabled, String location) {}
