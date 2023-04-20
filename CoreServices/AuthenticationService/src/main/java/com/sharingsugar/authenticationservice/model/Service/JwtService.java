package com.sharingsugar.authenticationservice.model.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    //@Value("${privateKey}")
    public final String SECRET;


    public JwtService(@Value("${privateKey}") String privateKey){
        this.SECRET=privateKey;
    }



    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);}

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    // private Claims extractAllClaims(String token) {
    //     return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    // }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }
    public Boolean validateTokenBool(final String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }


    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }
//    private Boolean isTokenExpired(String token) {
//
//        return extractExpiration(token).before(new Date());
//    }
    private String hi(){
        return "hi";
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60*24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
    private String createRefreshToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Boolean IstokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
