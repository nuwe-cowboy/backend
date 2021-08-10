package com.example.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@Autowired
	private SecurityService service;
	
	@Value("${secret}")
	private String secret;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> login) {
		return service.login(login);
	}

}
