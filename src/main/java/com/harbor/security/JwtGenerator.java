package com.harbor.security;

import org.springframework.stereotype.Component;

import com.harbor.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	private String secret = "hodor";
	
	public String generate(User user) {
		Claims claims =  Jwts.claims().setSubject(user.getUsername() );
		
		claims.put("userId", String.valueOf(user.getId()) );
		claims.put("role", user.getRole());
		
		
		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

}
