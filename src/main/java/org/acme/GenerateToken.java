package org.acme;

import io.smallrye.jwt.build.Jwt;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

@OpenAPIDefinition(
  info = @Info(title = "Downwork API", version = "1.0.0"),
  components = @Components(
    securitySchemes = {
      @SecurityScheme(
        securitySchemeName = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
      )
    }
  )
)
public class GenerateToken extends Application {

  public static void main(String[] args) {
    String token = Jwt
      .issuer("https://example.com/issuer")
      .upn("jdoe@quarkus.io")
      .groups(new HashSet<>(Arrays.asList("User", "Admin")))
      .claim(Claims.birthdate.name(), "2001-07-13")
      .expiresAt(Instant.now().plus(15, ChronoUnit.MINUTES))
      .sign();
    System.out.println(token);
  }
}
