package com.ballastlane.pokedex.infrastructure.cache;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** Catalog cache settings (stub). */
@ConfigurationProperties("app.catalog-cache")
public record CatalogCacheProperties(Duration ttl, Long maxEntries) {}
