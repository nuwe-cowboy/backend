package com.example.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.service.UserService;

@Service
public class SecurityService {
	
	@Autowired
	private UserService service;
	
	public Map<String, String> login(Map<String, String> login) {
		String username = login.get("username");
		String password = login.get("password");
		
		this.authenticate(username, password);
		
		List<GrantedAuthority> authorities = null;
		
		return this.generateToken(username, authorities);
	}
	
	public User authenticate(String username, String password) {
		return service.readByEmailAndPassword(username, password);
	}
	
	public Map<String, String> generateToken(String username, List<GrantedAuthority> authorities) {
		Map<String, String> token = new HashMap<>();
		token.put("token", "i'm a token");
		return token;
	}
	
}
