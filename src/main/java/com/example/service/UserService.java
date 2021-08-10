package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.User;
import com.example.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository repository;
	
	public List<User> read() {
		return repository.findAll();
	}
	
	public User readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User with id=" + id + " not found"));
	}
	
	public User readByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password)
			.orElseThrow(() -> new ResourceNotFoundException("User with email=" + email + " and password=" + password + " not found"));
	}
	
	public User create(User user) {
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
