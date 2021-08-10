package com.example.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityService {
	
	@Autowired
	private UserService service;
	
	//@Value("${secret}")
	private String secret = "mySecretKey";
	
	public Map<String, String> login(Map<String, String> login) {
		String username = login.get("username");
		String password = login.get("password");
		
		this.authenticate(username, password);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		return this.generateToken(username, authorities);
	}
	
	public User authenticate(String username, String password) {
		return service.readByEmailAndPassword(username, password);
	}
	
	public Map<String, String> generateToken(String username, List<GrantedAuthority> authorities) {
		long time = System.currentTimeMillis();
		
		String token = Jwts
			.builder()
			.setSubject(username)
			.claim("authorities", authorities
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList()))
			.setIssuedAt(new Date(time))
			.setExpiration(new Date(time + 600000))
			.signWith(SignatureAlgorithm.HS512, secret.getBytes())
			.compact();
		
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		
		return map;
	}
	
}
