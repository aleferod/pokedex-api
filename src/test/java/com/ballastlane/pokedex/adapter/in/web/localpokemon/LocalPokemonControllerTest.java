package com.ballastlane.pokedex.adapter.in.web.localpokemon;

import static com.ballastlane.pokedex.domain.localpokemon.LocalPokemonFixtures.pikachu;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import com.ballastlane.pokedex.application.port.in.localpokemon.GetLocalPokemon;
import com.ballastlane.pokedex.application.port.out.user.TokenPort;
import com.ballastlane.pokedex.domain.localpokemon.AuditInfo;
import com.ballastlane.pokedex.domain.localpokemon.InternalTags;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemon;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonId;
import com.ballastlane.pokedex.domain.localpokemon.LocalPokemonNotFoundException;
import com.ballastlane.pokedex.domain.localpokemon.LocalizedNames;
import com.ballastlane.pokedex.domain.localpokemon.ProprietaryData;
import com.ballastlane.pokedex.domain.pokemon.PokemonId;
import com.ballastlane.pokedex.domain.user.Role;
import com.ballastlane.pokedex.support.TestTokens;
import com.ballastlane.pokedex.support.WebSliceTest;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;

@WebSliceTest(controllers = LocalPokemonController.class)
class LocalPokemonControllerTest {

  private static final Instant IMPORTED = Instant.parse("2026-10-14T12:00:00Z");
  private static final LocalPokemonId ID = LocalPokemonId.random();

  @Autowired private MockMvcTester mvc;
  @Autowired private TokenPort tokenPort;
  @Autowired private JwtEncoder jwtEncoder;

  @MockitoBean private GetLocalPokemon getLocalPokemon;

  private String ash;

  @BeforeEach
  void setUp() {
    ash = new TestTokens(tokenPort, jwtEncoder).bearer(TestTokens.user("ash", Role.USER));
  }

  // ---- read one ---------------------------------------------------------------------------------

  @Test
  void should_returnRecordWithEtag_when_idExists() {
    given(getLocalPokemon.get(ID)).willReturn(withProprietaryData(7L));

    MvcTestResult result =
        mvc.get()
            .uri("/api/v1/local-pokemon/{id}", ID.value())
            .header(HttpHeaders.AUTHORIZATION, ash)
            .exchange();

    assertThat(result)
        .hasStatus(HttpStatus.OK)
        .hasContentType(MediaType.APPLICATION_JSON)
        .hasHeader(HttpHeaders.ETAG, "\"7\"");
    assertThat(result)
        .bodyJson()
        .extractingPath("$.internalTags")
        .asArray()
        .containsExactly("starter-line");
  }

  @Test
  void should_return404_when_idIsUnknown() {
    given(getLocalPokemon.get(ID)).willThrow(new LocalPokemonNotFoundException(ID));

    MvcTestResult result =
        mvc.get()
            .uri("/api/v1/local-pokemon/{id}", ID.value())
            .header(HttpHeaders.AUTHORIZATION, ash)
            .exchange();

    assertThat(result).hasStatus(HttpStatus.NOT_FOUND);
    assertThat(result)
        .bodyJson()
        .extractingPath("$.detail")
        .isEqualTo("No local Pokémon with id " + ID.value() + ".");
  }

  @Test
  void should_return400NamingId_when_idIsNotAUuid() {
    MvcTestResult result =
        mvc.get()
            .uri("/api/v1/local-pokemon/not-a-uuid")
            .header(HttpHeaders.AUTHORIZATION, ash)
            .exchange();

    assertThat(result).hasStatus(HttpStatus.BAD_REQUEST);
    assertThat(result).bodyJson().extractingPath("$.errors[0].field").isEqualTo("id");
    then(getLocalPokemon).shouldHaveNoInteractions();
  }

  private static LocalPokemon withProprietaryData(long version) {
    return new LocalPokemon(
        ID,
        new PokemonId(25),
        pikachu(61),
        new ProprietaryData(
            LocalizedNames.of(Map.of("pt-BR", "Pikachu")),
            "Kanto",
            null,
            InternalTags.of(List.of("starter-line")),
            null),
        new AuditInfo(IMPORTED, IMPORTED, IMPORTED, "ash"),
        version);
  }
}
