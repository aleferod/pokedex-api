package com.ballastlane.pokedex.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.lang.ArchRule;
import java.util.List;

/** Architecture rules for a given base package (stub: rules match nothing yet). */
final class ArchitectureRules {

  private ArchitectureRules() {}

  static ArchitectureRules forBasePackage(String basePackage) {
    return new ArchitectureRules();
  }

  ArchRule layerDependencies() {
    return matchesNothing();
  }

  ArchRule domainIsFrameworkFree() {
    return matchesNothing();
  }

  ArchRule applicationIsFrameworkFree() {
    return matchesNothing();
  }

  ArchRule adaptersAreIsolatedFromEachOther() {
    return matchesNothing();
  }

  ArchRule noFieldInjection() {
    return matchesNothing();
  }

  ArchRule noStandardStreams() {
    return matchesNothing();
  }

  ArchRule noJavaUtilLogging() {
    return matchesNothing();
  }

  List<ArchRule> all() {
    return List.of(
        layerDependencies(),
        domainIsFrameworkFree(),
        applicationIsFrameworkFree(),
        adaptersAreIsolatedFromEachOther(),
        noFieldInjection(),
        noStandardStreams(),
        noJavaUtilLogging());
  }

  private static ArchRule matchesNothing() {
    return noClasses().should().haveSimpleName("NoClassIsNamedLikeThis").allowEmptyShould(true);
  }
}
