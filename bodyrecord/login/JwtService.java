package com.example.structure.member.domain.login;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private static final String SECRET_KEY = "your-secret-key"; // JWT 서명에 사용할 비밀키

    public String createJwt(int user_num, String user_id) {
        return Jwts.builder()
                .claim("user_num", user_num)
                .claim("user_id", user_id)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
