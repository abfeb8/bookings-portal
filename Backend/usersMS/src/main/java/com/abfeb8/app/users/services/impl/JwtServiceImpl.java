package com.abfeb8.app.users.services.impl;

import com.abfeb8.app.users.services.specs.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

    private final JwtParser jwtParser;
    @Qualifier("jwtSigningKey")
    private final Key jwtSigningKey;
    @Qualifier("jwtExpMin")
    private final long jwtExpHrs;

    public JwtServiceImpl(
            @Autowired JwtParser jwtParser,
            @Autowired Key jwtSigningKey,
            @Autowired String jwtExpHrs
    ) {
        this.jwtParser = jwtParser;
        this.jwtSigningKey = jwtSigningKey;
        this.jwtExpHrs = Long.parseLong(jwtExpHrs);
    }

    @Override
    public String extractUserName(String token) {
        try {
            return extractClaim(token, Claims::getSubject);
        } catch (Exception ex) {
            log.error(
                    "error while extracting username from toke: {}, exception: {}, stacktrace: {}",
                    token,
                    ex.getMessage(),
                    ExceptionUtils.getStackTrace(ex)
            );
        }

        return null;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        try {
            return generateToken(new HashMap<>(), userDetails);
        } catch (Exception ex) {
            log.error(
                    "error while generating toke for user: {}, exception: {}, stacktrace: {}",
                    userDetails.getUsername(),
                    ex.getMessage(),
                    ExceptionUtils.getStackTrace(ex)
            );
        }

        return null;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            final String userName = extractUserName(token);
            return userName.equals(userDetails.getUsername())
                    && !isTokenExpired(token);
        } catch (Exception ex) {
            log.error("error while validating toke: {}, exception: {}, stacktrace: {}",
                    token,
                    ex.getMessage(),
                    ExceptionUtils.getStackTrace(ex));
        }

        return false;
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setIssuer("com.abfeb8.ms.user")
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(jwtExpHrs)))
                .signWith(jwtSigningKey, SignatureAlgorithm.HS256)
                .compact();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token)
                .before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return jwtParser
                .parseClaimsJws(token)
                .getBody();
    }

}
