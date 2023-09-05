package com.example.haru_shop.config;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class JwtUtils {
    public static SecretKey generateHS512Key() {
        String secret = "yourSecretKey";
        byte[] byteKey = secret.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(byteKey, SignatureAlgorithm.HS512.getJcaName());
    }
}
