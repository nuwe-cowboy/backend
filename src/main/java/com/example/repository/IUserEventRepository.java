package com.example.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.UserEvent;

@Repository
public interface IUserEventRepository extends MongoRepository<UserEvent, UUID> {		

	List<UserEvent> findByUserId(UUID userId);

	List<UserEvent> findByEventId(UUID eventId);
	
	void deleteByUserIdAndEventId(UUID userId, UUID eventId);
	
}