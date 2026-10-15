package com.ballastlane.pokedex.adapter.in.seed;

import com.ballastlane.pokedex.application.port.in.localpokemon.CreateLocalPokemon;
import com.ballastlane.pokedex.application.port.in.user.ProvisionUser;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/** Seeds demo data at startup (stub). */
public class DemoDataSeeder implements ApplicationRunner {

  /** What a run did. */
  public record Result(
      int accountsCreated,
      int accountsKept,
      int accountsFailed,
      int pokemonCreated,
      int pokemonKept,
      int pokemonFailed) {}

  private final DemoData data;
  private final ProvisionUser provisionUser;
  private final CreateLocalPokemon createLocalPokemon;

  public DemoDataSeeder(
      DemoData data, ProvisionUser provisionUser, CreateLocalPokemon createLocalPokemon) {
    this.data = data;
    this.provisionUser = provisionUser;
    this.createLocalPokemon = createLocalPokemon;
  }

  @Override
  public void run(ApplicationArguments args) {
    seed();
  }

  public Result seed() {
    return new Result(0, 0, 0, 0, 0, 0);
  }
}
