package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping
	public List<User> read() {
		return null;
	}
	
	@GetMapping("/{id}")
	public User readById(@PathVariable String id) {
		return null;
	}
	
	@PostMapping
	public User create() {
		return null;
	}
	
	@PutMapping("/{id}")
	public User updateById(@PathVariable String id) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable String id) {
	}
	
}
