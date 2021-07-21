package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

import com.example.repository.IUserRepository;
import com.example.domain.User;
import com.example.controller.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository repository;
	
	public List<User> read() {
		return repository.findAll();
	}
	
	public User readById(String id) {
		return repository.findById(new ObjectId(id)).orElseThrow(() -> new ResourceNotFoundException("User with id=" + id + " not found in database"));
	}
	
	public User create(User user) {
		return repository.save(user);
	}
	
	public User updateById(String id, User user) {
		user.setId(new ObjectId(id));
		return repository.save(user);
	}
	
	public void deleteById(String id) {
		repository.deleteById(new ObjectId(id));
	}
	
}
