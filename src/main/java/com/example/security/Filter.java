package com.example.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class Filter extends OncePerRequestFilter {
	
	private final String
		HEADER = "Authorization",
		PREFIX = "Bearer ";
	
	//@Value("${secret}")
	private String secret = "mySecretKey";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (this.isTokenValid(request, response)) {
			Claims claims = this.getClaims(request);
			
			if (claims.get("authorities") != null)
				this.setUpSpringAuthentication(claims);
			else
				SecurityContextHolder.clearContext();
		} else
			SecurityContextHolder.clearContext();
		
		filterChain.doFilter(request, response);
	}
	
	private boolean isTokenValid(HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader(HEADER);
		
		if (header == null || !header.startsWith(PREFIX))
			return false;
		
		return true;
	}
	
	private Claims getClaims(HttpServletRequest request) {
		String token = request.getHeader(HEADER).replace(PREFIX, "");
		
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}
	
	private void setUpSpringAuthentication(Claims claims) {
		List<String> authorities = Arrays.asList(claims.get("authorities").toString().split(","));
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
			claims
				.getSubject(),
			null,
			authorities
				.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
