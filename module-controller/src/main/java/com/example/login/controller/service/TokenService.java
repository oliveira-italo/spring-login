package com.example.login.controller.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.login.controller.enuns.Role;
import com.example.login.controller.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class TokenService {

    private static final String ISSUER = "email";
    private static final String UUID_CLAIM = "uuid";
    private static final String ROLE_CLAIM = "role";
    private static final String PASSWORD_CLAIM = "password";

    @Value("${security.token.secret}")
    private String secret;

    public String create(UserLoginDTO user) {
        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.email())
                    .withClaim(UUID_CLAIM, user.uuid())
                    .withClaim(ROLE_CLAIM, user.role().name())
                    .withClaim(PASSWORD_CLAIM, user.getPassword())
                    .withExpiresAt(LocalDateTime.now().plusHours(2).atZone(ZoneId.systemDefault()).toInstant())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception) {
            throw new RuntimeException("error generating jwt", exception);
        }
    }

    public UserLoginDTO verify(String jwt) throws JWTVerificationException {
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer(ISSUER)
                .build()
                .verify(jwt);

        return new UserLoginDTO(
                decodedJWT.getClaim(UUID_CLAIM).asString(),
                decodedJWT.getSubject(),
                decodedJWT.getClaim(PASSWORD_CLAIM).asString(),
                Role.valueOf(decodedJWT.getClaim(ROLE_CLAIM).asString())
        );
    }
}
