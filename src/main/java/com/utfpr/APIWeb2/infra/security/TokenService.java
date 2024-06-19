package com.utfpr.APIWeb2.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.utfpr.APIWeb2.core.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secretKey;

    //Gera o Token
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String token = JWT.create()
                    .withIssuer("APIWeb2")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException ex){
            throw new RuntimeException("Generate token error!");
        }
    }

    //Valida o token
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                    .withIssuer("APIWeb2")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException ex){
            return "";
        }
    }

    //Gera uma data para o fim do token
    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
