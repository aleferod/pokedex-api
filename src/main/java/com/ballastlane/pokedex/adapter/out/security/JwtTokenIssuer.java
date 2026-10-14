package com.ballastlane.pokedex.adapter.out.security;

import com.ballastlane.pokedex.application.port.out.user.IssuedToken;
import com.ballastlane.pokedex.application.port.out.user.TokenPort;
import com.ballastlane.pokedex.domain.user.User;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import org.springframework.security.oauth2.jwt.JwtEncoder;

/** Issues signed JWT access tokens (stub). */
public class JwtTokenIssuer implements TokenPort {

  public JwtTokenIssuer(JwtEncoder encoder, Clock clock, Duration ttl, String issuer) {}

  @Override
  public IssuedToken issue(User user) {
    return new IssuedToken("stub", Instant.EPOCH);
  }
}
