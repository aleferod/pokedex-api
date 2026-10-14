package com.ballastlane.pokedex.infrastructure.security;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** Access-token settings ({@code app.security.jwt.*}) (stub: no validation yet). */
@ConfigurationProperties("app.security.jwt")
public record JwtProperties(String secret, Duration ttl, String issuer) {}
