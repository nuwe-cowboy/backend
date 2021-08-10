package com.example.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Event;
import com.example.service.EventService;

@RestController
@RequestMapping("/events")
public class EventRestController {
	
	@Autowired
	private EventService service;
	
	@GetMapping
	public List<Event> read() {
		return service.read();
	}
	
	@GetMapping("/{id}")
	public Event readById(@PathVariable UUID id) {
		return service.readById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Event create(@Valid @RequestBody Event event) {
		return service.create(event);
	}
	
	@PutMapping("/{id}")
	public Event updateById(@PathVariable UUID id, @Valid @RequestBody Event event) {
		return service.updateById(id, event);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable UUID id) {
		service.deleteById(id);
	}
	
}
