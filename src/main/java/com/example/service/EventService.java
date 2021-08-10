package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Event;
import com.example.repository.IEventRepository;

@Service
public class EventService {
	
	@Autowired
	private IEventRepository repository;
	
	public List<Event> read() {
		return repository.findAll();
	}
	
	public Event readById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event with id=" + id + " not found"));
	}
	
	public Event create(Event event) {
		event.setTimestamp(LocalDateTime.now());
		return repository.save(event);
	}
	
	public Event updateById(UUID id, Event event) {
		event.setId(id);
		return repository.save(event);
	}
	
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
	
}
