package com.ballastlane.pokedex.domain.user;

import java.util.Optional;

/** One link of the password policy chain: returns the violation message, if any. */
@FunctionalInterface
public interface PasswordRule {

  Optional<String> violation(String password);
}
