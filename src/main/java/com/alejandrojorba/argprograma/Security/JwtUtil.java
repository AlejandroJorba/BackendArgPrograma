package com.alejandrojorba.argprograma.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtil {
    @Value("${secretKey}")
    private String SECRET_KEY;
    private String USER = "user";
    private String BEARER = "Bearer ";

    public String generateToken(String username) throws JWTCreationException{
        try {
            String token = JWT.create()
                    .withIssuer("ArgPrograma")
                    .withIssuedAt(new Date())
                    .withClaim(USER, username)
                    .withExpiresAt(new Date(System.currentTimeMillis()+3600000))
                    .sign(Algorithm.HMAC512(SECRET_KEY));
            return token;
        } catch (JWTCreationException exception){
            return exception.getMessage();
        }
    }

    public boolean isBearer(String token) throws JWTCreationException{
        return token != null && token.startsWith(BEARER) && token.split("\\.").length == 3;
    }

    public String user(String token) {
            return verify(token).getClaim(USER).asString();
    }

    public DecodedJWT verify(String token) throws JWTVerificationException {
        if(!isBearer(token)) throw new JWTVerificationException("No es un token válido");
        try {
            return JWT.require(Algorithm.HMAC512(SECRET_KEY))
                    .withIssuer("ArgPrograma")
                    .build()
                    .verify(token.substring(BEARER.length()));
        }
        catch (Exception e){
            throw new JWTVerificationException("JWT is wrong " + e.getMessage());
        }
    }
}
