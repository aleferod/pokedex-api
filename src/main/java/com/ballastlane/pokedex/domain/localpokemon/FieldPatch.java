package com.ballastlane.pokedex.domain.localpokemon;

/** One field of a merge patch (stub). */
public sealed interface FieldPatch<T> permits FieldPatch.Keep, FieldPatch.Clear, FieldPatch.Set {

  static <T> FieldPatch<T> keep() {
    return new Keep<>();
  }

  static <T> FieldPatch<T> clear() {
    return new Clear<>();
  }

  static <T> FieldPatch<T> set(T value) {
    return new Set<>(value);
  }

  T resolve(T current);

  /** Leave the field as it is. */
  record Keep<T>() implements FieldPatch<T> {
    @Override
    public T resolve(T current) {
      return null;
    }
  }

  /** Remove the field's value. */
  record Clear<T>() implements FieldPatch<T> {
    @Override
    public T resolve(T current) {
      return null;
    }
  }

  /** Replace the field's value. */
  record Set<T>(T value) implements FieldPatch<T> {
    @Override
    public T resolve(T current) {
      return null;
    }
  }
}
