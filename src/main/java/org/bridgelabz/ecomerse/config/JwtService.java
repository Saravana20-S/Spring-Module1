package org.bridgelabz.ecomerse.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private final String SECRET_KEY = "my-super-secret-key-my-super-secret-key-123456";

    private SecretKey signedKey=Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));


    // =========================
    // Generate JWT
    // =========================

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        +  1000 * 60 * 60
                        )
                )
                .signWith(signedKey)
                .compact();
    }


    // =========================
    // Extract Username
    // =========================

    public String extractUsername(String token) {

        return Jwts.parser()
                .verifyWith(signedKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }







    // =========================
    // Validate JWT
    // =========================

    public boolean isTokenValid(
            String token,
            UserDetails userDetails) {

        String username =
                extractUsername(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }


    // =========================
    // Check Expiration
    // =========================

    private boolean isTokenExpired(String token) {

        Date expiration =Jwts.parser()
                .verifyWith(signedKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();

        return expiration.before(new Date());
    }


}
