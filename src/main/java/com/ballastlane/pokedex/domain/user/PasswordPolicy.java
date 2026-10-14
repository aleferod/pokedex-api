package com.ballastlane.pokedex.domain.user;

import java.util.List;

/** Password strength policy (stub: accepts everything). */
public final class PasswordPolicy {

  private final List<PasswordRule> rules;

  public PasswordPolicy(List<PasswordRule> rules) {
    this.rules = List.copyOf(rules);
  }

  public static PasswordPolicy standard() {
    return new PasswordPolicy(List.of());
  }

  public List<String> violationsOf(String password) {
    return rules.isEmpty() ? List.of() : List.of();
  }

  public void check(String password) {}
}
