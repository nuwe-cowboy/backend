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
public class UserEventRestControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenReadByUserId_thenStatus200() throws Exception {
		String id1 = "11110000-0000-0000-0000-000000000000",
			id2 = "22220000-0000-0000-0000-000000000000",
			userId = "11110000-0000-0000-0000-000000000000",
			eventId1 = "11110000-0000-0000-0000-000000000000",
			eventId2 = "22220000-0000-0000-0000-000000000000";
		double distance1 = 10, distance2 = 20;
		
		mockMvc
			.perform(get("/users/" + userId + "/events")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].id", is(id1)))
			.andExpect(jsonPath("$[0].userId", is(userId)))
			.andExpect(jsonPath("$[0].eventId", is(eventId1)))
			.andExpect(jsonPath("$[0].distance", is(distance1)))
			.andExpect(jsonPath("$[1].id", is(id2)))
			.andExpect(jsonPath("$[1].userId", is(userId)))
			.andExpect(jsonPath("$[1].eventId", is(eventId2)))
			.andExpect(jsonPath("$[1].distance", is(distance2)));
	}
	
	@Test
	public void givenReadByEventId_thenStatus200() throws Exception {
		String id1 = "11110000-0000-0000-0000-000000000000",
			id2 = "33330000-0000-0000-0000-000000000000",
			userId1 = "11110000-0000-0000-0000-000000000000",
			userId2 = "22220000-0000-0000-0000-000000000000",
			eventId = "11110000-0000-0000-0000-000000000000";
		double distance1 = 10, distance2 = 30;
		
		mockMvc
			.perform(get("/events/" + eventId + "/users")
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].id", is(id1)))
			.andExpect(jsonPath("$[0].userId", is(userId1)))
			.andExpect(jsonPath("$[0].eventId", is(eventId)))
			.andExpect(jsonPath("$[0].distance", is(distance1)))
			.andExpect(jsonPath("$[1].id", is(id2)))
			.andExpect(jsonPath("$[1].userId", is(userId2)))
			.andExpect(jsonPath("$[1].eventId", is(eventId)))
			.andExpect(jsonPath("$[1].distance", is(distance2)));
	}
	
	@Test
	public void givenCreate_thenStatus201() throws Exception {
		String userId = "33330000-0000-0000-0000-000000000000",
			eventId = "33330000-0000-0000-0000-000000000000";
		
		JSONObject json = new JSONObject();
		
		json.put("userId", userId);
		json.put("eventId", eventId);
		
		String content = json.toString();
		
		mockMvc
			.perform(post("/users/" + userId + "/events/" + eventId)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.userId", is(userId)))
			.andExpect(jsonPath("$.eventId", is(eventId)));
	}
	
	@Test
	public void givenUpdate_thenStatus200() throws Exception {
		String id = "44440000-0000-0000-0000-000000000000",
			userId = "22220000-0000-0000-0000-000000000000",
			eventId = "22220000-0000-0000-0000-000000000000";
		double distance = 50;
		
		JSONObject json = new JSONObject();

		json.put("id", id);
		json.put("userId", userId);
		json.put("eventId", eventId);
		json.put("distance", distance);
		
		String content = json.toString();
		
		mockMvc
			.perform(put("/users/" + userId + "/events/" + eventId)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(id)))
			.andExpect(jsonPath("$.userId", is(userId)))
			.andExpect(jsonPath("$.eventId", is(eventId)))
			.andExpect(jsonPath("$.distance", is(distance)));
	}
	
	@Test
	public void givenDelete_thenStatus204() throws Exception {
		String /*id = "55550000-0000-0000-0000-000000000000",*/
			userId = "22220000-0000-0000-0000-000000000000",
			eventId = "33330000-0000-0000-0000-000000000000";/*;
		double distance = 50;
			
		JSONObject json = new JSONObject();
		
		json.put("id", id);
		json.put("userId", userId);
		json.put("eventId", eventId);
		json.put("distance", distance);
		
		String content = json.toString();*/
		
		mockMvc
			.perform(delete("/users/" + userId + "/events/" + eventId)/*
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)*/)
			.andExpect(status().isNoContent());
	}
	
}
