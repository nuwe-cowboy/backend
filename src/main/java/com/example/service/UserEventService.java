package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.UserEvent;
import com.example.repository.IUserEventRepository;

@Service
public class UserEventService {
	
	@Autowired
	private IUserEventRepository repository;
	
	public List<UserEvent> readByUserId(UUID userId) {
		return repository.findByUserId(userId);
	}
	
	public List<UserEvent> readByEventId(UUID eventId) {
		return repository.findByEventId(eventId);
	}
	
	public UserEvent create(UUID userId, UUID eventId) {
		UserEvent userEvent = new UserEvent();
		
		userEvent.setUserId(userId);
		userEvent.setEventId(eventId);
		
		return repository.save(userEvent);
	}
	
	public UserEvent update(UUID userId, UUID eventId, UserEvent userEvent) {
		userEvent.setUserId(userId);
		userEvent.setEventId(eventId);
		
		return repository.save(userEvent);
	}
	
	public void deleteByUserIdAndEventId(UUID userId, UUID eventId) {
		repository.deleteByUserIdAndEventId(userId, eventId);
	}
	
}
