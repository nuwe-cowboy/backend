package com.example.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.domain.ERole;
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
		
		User user = this.authenticate(username, password);
		List<String> authorities = this.authorize(user);
		
		return this.generateToken(username, authorities);
	}
	
	public User authenticate(String username, String password) {
		return service.readByEmailAndPassword(username, password);
	}
	
	public List<String> authorize(User user) {
		ERole role = user.getRole();
		
		List<String> authorities = new ArrayList<>();
		authorities.add("ROLE_" + role);
		
		return authorities;
	}
	
	public Map<String, String> generateToken(String username, List<String> authorities) {
		long time = System.currentTimeMillis();
		
		String token = Jwts
			.builder()
			.setSubject(username)
			.claim("authorities", authorities)
			.setIssuedAt(new Date(time))
			.setExpiration(new Date(time + 600000))
			.signWith(SignatureAlgorithm.HS512, secret.getBytes())
			.compact();
		
		Map<String, String> map = new HashMap<>();
		map.put("token", token);
		
		return map;
	}
	
}
