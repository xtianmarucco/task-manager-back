package org.taskmanager.taskmanagerback.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    // Tiempo de expiración: 1 día
    private static final long EXPIRATION_TIME = 86400000;

    // Clave secreta para firmar el token (reemplaza con una segura en producción)
    private static final String SECRET_KEY = "clave-secreta-segura-para-firmar-jwt-1234567890";

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // ✅ Generar un token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // usuario que se loguea
                .setIssuedAt(new Date()) // fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // vencimiento
                .signWith(key, SignatureAlgorithm.HS256) // algoritmo de firma
                .compact();
    }

    // ✅ Obtener el username desde un token
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // ✅ Validar si un token es correcto (firma válida y no expirado)
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("❌ Token inválido: " + e.getMessage());
            return false;
        }
    }
}