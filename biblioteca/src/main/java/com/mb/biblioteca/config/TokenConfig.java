package com.mb.biblioteca.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mb.biblioteca.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {
    private String secret = "secret";

    Algorithm algorithm = Algorithm.HMAC256(secret);

    public String generateToken(User user) {
        return JWT.create()
                .withClaim("userId", user.getId())
                .withClaim("roles", user.getRoles().stream().map(Enum::name).toList())
                .withSubject(user.getMatricula())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT decode = JWT.require(algorithm)
                    .build().verify(token);

            return Optional.of(JWTUserData.builder()
                    .userId(decode.getClaim("userId").asLong())
                    .matricula(decode.getSubject())
                    .roles(decode.getClaim("roles").asList(String.class))
                    .build());

        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }
}
