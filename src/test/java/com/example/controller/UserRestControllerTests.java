package com.example.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class UserRestControllerTests {
	
	private String endpoint = "/users";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenRead_thenStatus200() throws Exception {
		mockMvc
			.perform(get(endpoint)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	public void givenReadById_thenStatus200() throws Exception {
		String id = "11110000-0000-0000-0000-000000000000",
			name = "John", lastName = "Doe",
			email = "john@example.com", password = "$2a$10$4bNJAICKUh8USNvKmSICwud3vkb6ZwVgwDdNY.mWexqcNs4ZdIzrS",
			role = "DEFAULT";
		
		mockMvc
			.perform(get(endpoint + "/" + id)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(id)))
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect(jsonPath("$.lastName", is(lastName)))
			.andExpect(jsonPath("$.email", is(email)))
			.andExpect(jsonPath("$.password", is(password)))
			.andExpect(jsonPath("$.role", is(role)));
	}
	
	@Test
	public void givenCreateDefault_thenStatus201() throws Exception {
		String email = "test1@example.com", password = "123456",
			role = "DEFAULT";
		
		JSONObject json = new JSONObject();
		
		json.put("email", email);
		json.put("password", password);
		
		String content = json.toString();
		
		mockMvc
			.perform(post(endpoint + "/default")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.email", is(email)))
			.andExpect(jsonPath("$.role", is(role)));
	}
	
	@Test
	public void givenCreateAdmin_thenStatus201() throws Exception {
		String email = "test2@example.com", password = "123456",
			role = "ADMIN";
		
		JSONObject json = new JSONObject();
		
		json.put("email", email);
		json.put("password", password);
		
		String content = json.toString();
		
		mockMvc
			.perform(post(endpoint + "/admin")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.email", is(email)))
			.andExpect(jsonPath("$.role", is(role)));
	}
	
	@Test
	public void givenUpdate_thenStatus200() throws Exception {
		String id = "22220000-0000-0000-0000-000000000000",
			name = "Jane", lastName = "Doe",
			email = "jane@example.com", password = "$2a$10$JUs4hN/U73Hrcbf6LV3aW.sZcUTbcVLrcuG5FwDVYsfiRo2afgJ7O",
			role = "DEFAULT";
		
		JSONObject json = new JSONObject();
		
		json.put("id", id);
		json.put("name", name);
		json.put("lastName", lastName);
		json.put("email", email);
		json.put("password", password);
		json.put("role", role);
		
		String content = json.toString();
		
		mockMvc
			.perform(put(endpoint + "/" + id)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(id)))
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect(jsonPath("$.lastName", is(lastName)))
			.andExpect(jsonPath("$.email", is(email)))
			.andExpect(jsonPath("$.password", is(password)))
			.andExpect(jsonPath("$.role", is(role)));
	}
	
	@Test
	public void givenDelete_thenStatus204() throws Exception {
		String id = "33330000-0000-0000-0000-000000000000";/*,
			name = "George", lastName = "O'Malley",
			email = "george@example.com", password = "$2a$10$dek627gZNaA8MbmUSrLQceLd6YGbvwZlUrO.lks8JMZFdY9RfyHaG",
			role = "DEFAULT";
			
		JSONObject json = new JSONObject();
		
		json.put("id", id);
		json.put("name", name);
		json.put("lastName", lastName);
		json.put("email", email);
		json.put("password", password);
		json.put("role", role);
		
		String content = json.toString();*/
		
		mockMvc
			.perform(delete(endpoint + "/" + id)/*
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)*/)
			.andExpect(status().isNoContent());
	}
	
}
