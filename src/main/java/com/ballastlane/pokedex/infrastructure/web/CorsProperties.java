package com.ballastlane.pokedex.infrastructure.web;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** Allowed cross-origin callers (stub: no validation yet). */
@ConfigurationProperties("app.cors")
public record CorsProperties(List<String> allowedOrigins) {}
