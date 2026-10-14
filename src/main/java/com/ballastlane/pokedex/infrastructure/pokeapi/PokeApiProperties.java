package com.ballastlane.pokedex.infrastructure.pokeapi;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** PokeAPI client settings ({@code app.pokeapi.*}) (stub: no defaults or validation yet). */
@ConfigurationProperties("app.pokeapi")
public record PokeApiProperties(
    String baseUrl,
    Duration connectTimeout,
    Duration readTimeout,
    Integer maxConcurrency,
    String userAgent) {}
