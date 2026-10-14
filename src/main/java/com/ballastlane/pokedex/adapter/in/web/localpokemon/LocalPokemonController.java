package com.ballastlane.pokedex.adapter.in.web.localpokemon;

import com.ballastlane.pokedex.application.port.in.localpokemon.GetLocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The local replica as a REST resource. Authenticated only. Every single-record response carries an
 * {@code ETag} with the record's version. Importing from PokeAPI lives in {@link
 * LocalPokemonSyncController}.
 */
@RestController
@RequestMapping(LocalPokemonController.BASE_PATH)
@Tag(name = "Local Pokémon", description = "Locally owned copies with proprietary fields")
@SecurityRequirement(name = "bearer-jwt")
public class LocalPokemonController {

  public static final String BASE_PATH = "/api/v1/local-pokemon";

  private final GetLocalPokemon getLocalPokemon;

  public LocalPokemonController(GetLocalPokemon getLocalPokemon) {
    this.getLocalPokemon = getLocalPokemon;
  }

  @GetMapping("/{id}")
  @Operation(summary = "One local record")
  @ApiResponse(responseCode = "200", description = "The record, with its version as ETag")
  @ApiResponse(responseCode = "404", description = "Unknown id")
  public ResponseEntity<LocalPokemonResponse> get(@PathVariable String id) {
    LocalPokemon pokemon = getLocalPokemon.get(LocalPokemonId.parse(id));
    return ResponseEntity.ok()
        .eTag(LocalPokemonWebMapper.etag(pokemon))
        .body(LocalPokemonWebMapper.toResponse(pokemon));
  }
}
