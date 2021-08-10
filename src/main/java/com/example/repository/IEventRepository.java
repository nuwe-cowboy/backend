package com.example.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Event;

@Repository
public interface IEventRepository extends MongoRepository<Event, UUID> {
}
