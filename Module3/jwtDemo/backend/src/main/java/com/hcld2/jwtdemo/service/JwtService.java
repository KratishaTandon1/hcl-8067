package com.hcld2.jwtdemo.service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.*;

@Service
public class JwtService {
    private final Algorithm algorithm;
    private final JWTVerifier verifier;
    private final long expirationTime;
    public JwtService(@Value ("${app.jwt.secret}") String secret, @Value("${app.jwt.expiration-ms}") long expirationTime) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algorithm).build();
        this.expirationTime = expirationTime;
    }

    public String generateToken(String username,String password) {
        Date now = new Date();
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + expirationTime))
                .sign(algorithm);
     

    }

    public String verifyAndGetUsername(String token) {
          try{
            return verifier.verify(token).getSubject();
          }catch(Exception e){
            return null;
          }
    }
    
}
