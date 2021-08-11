package com.example.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRestController {
	
	@Autowired
	private SecurityService service;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> login) {
		return service.login(login);
	}

}
