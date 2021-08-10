package com.example.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public interface IUserRepository extends MongoRepository<User, UUID> {
	
	Optional<User> findByEmailAndPassword(String email, String password);
	
}
