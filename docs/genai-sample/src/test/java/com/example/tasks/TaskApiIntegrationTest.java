package com.example.tasks;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.tasks.persistence.UserEntity;
import com.example.tasks.persistence.UserRepository;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "tasks.jwt.secret=" + TaskApiIntegrationTest.SECRET)
class TaskApiIntegrationTest {

  static final String SECRET = "integration-test-secret-of-at-least-32-bytes";

  @Container @ServiceConnection
  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

  @Autowired private TestRestTemplate rest;
  @Autowired private UserRepository users;

  @BeforeEach
  void users() {
    if (users.findByUsername("alice").isEmpty()) {
      users.save(new UserEntity(UUID.randomUUID(), "alice"));
      users.save(new UserEntity(UUID.randomUUID(), "bob"));
    }
  }

  @Test
  void fullLifecycle() throws Exception {
    HttpHeaders alice = bearer("alice");
    HttpHeaders bob = bearer("bob");

    ResponseEntity<Map> created =
        rest.exchange(
            "/api/v1/tasks",
            HttpMethod.POST,
            new HttpEntity<>(Map.of("title", "Buy milk"), alice),
            Map.class);
    assertThat(created.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    String location = created.getHeaders().getLocation().toString();

    rest.exchange(
        "/api/v1/tasks", HttpMethod.POST, new HttpEntity<>(Map.of("title", "Bob's task"), bob), Map.class);

    ResponseEntity<Map> aliceTasks =
        rest.exchange("/api/v1/tasks", HttpMethod.GET, new HttpEntity<>(alice), Map.class);
    assertThat(aliceTasks.getBody().get("totalElements")).isEqualTo(1);

    ResponseEntity<Map> forBob =
        rest.exchange(location, HttpMethod.GET, new HttpEntity<>(bob), Map.class);
    assertThat(forBob.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

    ResponseEntity<Map> stale =
        rest.exchange(
            location,
            HttpMethod.PUT,
            new HttpEntity<>(
                Map.of("title", "Buy oat milk", "status", "DONE", "version", 7), alice),
            Map.class);
    assertThat(stale.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);

    ResponseEntity<Void> deleted =
        rest.exchange(location, HttpMethod.DELETE, new HttpEntity<>(alice), Void.class);
    assertThat(deleted.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

    ResponseEntity<Map> gone =
        rest.exchange(location, HttpMethod.GET, new HttpEntity<>(alice), Map.class);
    assertThat(gone.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  private static HttpHeaders bearer(String username) throws Exception {
    JWTClaimsSet claims =
        new JWTClaimsSet.Builder()
            .subject(username)
            .issueTime(new Date())
            .expirationTime(Date.from(Instant.now().plusSeconds(300)))
            .build();
    SignedJWT jwt = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claims);
    jwt.sign(new MACSigner(SECRET.getBytes(StandardCharsets.UTF_8)));
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(jwt.serialize());
    return headers;
  }
}
