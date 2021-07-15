package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.service.UserService;
import com.example.domain.User;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> read() {
		return service.read();
	}
	
	@GetMapping("/{id}")
	public User readById(@PathVariable String id) {
		System.out.println(id);
		return service.readById(id);
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		return service.create(user);
	}
	
	@PutMapping("/{id}")
	public User updateById(@PathVariable String id, @RequestBody User user) {
		return service.updateById(id, user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}
	
}
