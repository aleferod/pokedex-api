package com.ballastlane.pokedex.adapter.out.pokeapi;

import java.util.List;
import java.util.function.Function;

/** Runs tasks in parallel with an instance-wide cap (stub: does nothing yet). */
public final class BoundedFanOut {

  public BoundedFanOut(int maxConcurrency) {}

  public <T, R> List<R> map(List<T> inputs, Function<T, R> task) {
    return List.of();
  }
}
