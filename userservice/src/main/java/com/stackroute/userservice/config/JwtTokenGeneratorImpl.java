package com.stackroute.userservice.config;

import com.stackroute.userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
@Service
public class JwtTokenGeneratorImpl implements JwtTokenGenerator {
    @Value("${jwt.secret.key}")
    private String secretKey;


    @Override
    public Map<String, String> generateToken(User user) {
        String token = Jwts.builder().setSubject(user.getEmail())
                .setIssuer("APPIssuer")
                .setIssuedAt(new Date())
                //using HS256 algorithm for generating token
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return Map.of("token", token);
    }
}
