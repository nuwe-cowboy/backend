package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

import com.example.domain.User;

@Repository
public interface IUserRepository extends MongoRepository<User, ObjectId> {
}
