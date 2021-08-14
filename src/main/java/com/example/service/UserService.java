package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.ERole;
import com.example.domain.User;
import com.example.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> read() {
		return repository.findAll();
	}
	
	public User readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User with id=" + id + " not found"));
	}
	
	public User readByEmail(String email) {
		return repository.findByEmail(email)
			.orElseThrow(() -> new ResourceNotFoundException("User with email=" + email + " not found"));
	}
	
	public User create(User user, ERole role) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(role);
		return repository.save(user);
	}
	
	public User updateById(UUID id, User user) {
		user.setId(id);
		return repository.save(user);
	}
	
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
	
}
