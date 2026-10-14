package com.ballastlane.pokedex.adapter.out.pokeapi;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import java.time.Duration;
import java.util.function.Supplier;

/** Retry and circuit breaker around every PokeAPI request (stub: calls straight through). */
public final class PokeApiResilience {

  /** Plain settings, mapped from configuration by the infrastructure. */
  public record Settings(
      int maxAttempts,
      Duration initialBackoff,
      float failureRateThreshold,
      int minimumCalls,
      int slidingWindow,
      Duration openDuration) {}

  public PokeApiResilience(Settings settings) {}

  <T> T call(String what, Supplier<T> request) {
    return request.get();
  }

  CircuitBreaker.State circuitState() {
    return CircuitBreaker.State.CLOSED;
  }
}
