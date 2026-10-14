package com.ballastlane.pokedex.infrastructure.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.core.env.StandardEnvironment;

/**
 * Checks how application.yml and the profile files resolve, without starting the application or a
 * database. The host's environment variables are removed so a developer's shell cannot hide a
 * missing setting.
 */
class ProfileConfigurationTest {

  private final ApplicationContextRunner runner =
      new ApplicationContextRunner()
          .withInitializer(
              context ->
                  context
                      .getEnvironment()
                      .getPropertySources()
                      .remove(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME))
          .withInitializer(new ConfigDataApplicationContextInitializer());

  @Test
  void should_useLocalProfile_when_noProfileIsActive() {
    runner.run(
        context -> {
          assertThat(context.getEnvironment().getActiveProfiles()).isEmpty();
          assertThat(context.getEnvironment().getDefaultProfiles()).containsExactly("local");
          assertThat(context.getEnvironment().getProperty("spring.datasource.url"))
              .isEqualTo("jdbc:postgresql://localhost:5432/pokedex");
        });
  }

  @Test
  void should_targetComposeDatabaseOnPort8080_when_dockerProfileIsActive() {
    runner
        .withPropertyValues("spring.profiles.active=docker", "DB_PASSWORD=placeholder")
        .run(
            context -> {
              assertThat(context.getEnvironment().getProperty("spring.datasource.url"))
                  .isEqualTo("jdbc:postgresql://postgres:5432/pokedex");
              assertThat(context.getEnvironment().getProperty("server.port")).isEqualTo("8080");
            });
  }

  @Test
  void should_failNamingTheVariable_when_dockerProfileLacksDbPassword() {
    runner
        .withUserConfiguration(DataSourcePropertiesOnly.class)
        .withPropertyValues("spring.profiles.active=docker")
        .run(
            context -> {
              assertThat(context).hasFailed();
              assertThat(context.getStartupFailure()).rootCause().hasMessageContaining("DB_PASSWORD");
            });
  }

  @ParameterizedTest
  @ValueSource(strings = {"local", "docker", "test"})
  void should_onlyValidateSchema_when_anyProfileIsActive(String profile) {
    runner
        .withPropertyValues("spring.profiles.active=" + profile, "DB_PASSWORD=placeholder")
        .run(
            context ->
                assertThat(context.getEnvironment().getProperty("spring.jpa.hibernate.ddl-auto"))
                    .isEqualTo("validate"));
  }

  @EnableConfigurationProperties(DataSourceProperties.class)
  static class DataSourcePropertiesOnly {}
}
