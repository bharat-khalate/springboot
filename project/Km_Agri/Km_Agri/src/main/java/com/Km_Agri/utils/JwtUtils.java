package com.Km_Agri.utils;


import com.Km_Agri.entities.Auth;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtils {
    // Recommended to use at least 256-bit (32-byte) key for HS256
    @Value("${jwt.secretKey}")
    private String SECRET_KEY;
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // Create SecretKey instance from the base64 encoded key
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Auth authEntity) {
        Map<String, Object> claims = new HashMap<>();
//        claims.put("userName", authEntity.getUserName());
        claims.put("id", authEntity.getUser().getId());
        claims.put("role", authEntity.getRole());

        return Jwts.builder()
                .claims(claims)
                .subject(authEntity.getUserName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), Jwts.SIG.HS256)
                .compact();
    }

    public Claims getClaims(String token) throws JwtException {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token) {
        try {
            return !getClaims(token).getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }
}