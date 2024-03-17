package com.abfeb8.app.booking.users.configuration;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.security.Key;

@Configuration
@PropertySource("classpath:/jwt_config.yml")
@RequiredArgsConstructor
public class JwtConfig {

    private final Environment env;

    @Bean
    public JwtParser createJwtParser() {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build();
    }

    @Bean(name = "jwtSingingKey")
    public Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(env.getProperty("JWT_SIGNING_KEY"));
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Bean(name = "jwtExpMin")
    public String getJwtExpMin() {
        return env.getProperty("JWT_EXP_MINUTES");
    }

}
