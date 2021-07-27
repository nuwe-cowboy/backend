package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

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
		return service.readById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@Valid @RequestBody User user) {
		return service.create(user);
	}
	
	@PutMapping("/{id}")
	public User updateById(@PathVariable String id, @Valid @RequestBody User user) {
		return service.updateById(id, user);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}
	
}
