package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.UserEvent;
import com.example.service.UserEventService;

@RestController
public class UserEventRestController {
	
	@Autowired
	private UserEventService service;
	
	@GetMapping("/users/{userId}/events")
	public List<UserEvent> readByUserId(@PathVariable UUID userId) {
		return service.readByUserId(userId);
	}
	
	@GetMapping("/events/{eventId}/users")
	public List<UserEvent> readByEventId(@PathVariable UUID eventId) {
		return service.readByEventId(eventId);
	}
	
	@PostMapping("/users/{userId}/events/{eventId}")
	@ResponseStatus(HttpStatus.CREATED)
	public UserEvent create(@PathVariable UUID userId, @PathVariable UUID eventId) {
		return service.create(userId, eventId);
	}
	
	@PutMapping("/users/{userId}/events/{eventId}")
	public UserEvent update(@PathVariable UUID userId, @PathVariable UUID eventId, @RequestBody UserEvent userEvent) {
		return service.update(userId, eventId, userEvent);
	}
	
	@DeleteMapping("/users/{userId}/events/{eventId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteByUserIdAndEventId(@PathVariable UUID userId, @PathVariable UUID eventId) {
		service.deleteByUserIdAndEventId(userId, eventId);
	}
	
}
