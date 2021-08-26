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
public class ArticleRestControllerTests {
	
	private String endpoint = "/articles";
	
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
			title = "Lorem ipsum 1", body = "Dolor sit amet 1",
			timestamp = "01-01-2001 01:01:01";
		
		mockMvc
			.perform(get(endpoint + "/" + id)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(id)))
			.andExpect(jsonPath("$.title", is(title)))
			.andExpect(jsonPath("$.body", is(body)))
			.andExpect(jsonPath("$.timestamp", is(timestamp)));
	}
	
	@Test
	public void givenCreate_thenStatus201() throws Exception {
		String title = "Lorem ipsum 4", body = "Dolor sit amet 4";
		
		JSONObject json = new JSONObject();
		
		json.put("title", title);
		json.put("body", body);
		
		String content = json.toString();
		
		mockMvc
			.perform(post(endpoint)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.title", is(title)))
			.andExpect(jsonPath("$.body", is(body)));
	}
	
	@Test
	public void givenUpdate_thenStatus200() throws Exception {
		String id = "22220000-0000-0000-0000-000000000000",
			title = "Dolor sit amet 2", body = "Lorem ipsum 2",
			timestamp = "02-02-2002 02:02:02";
		
		JSONObject json = new JSONObject();
		
		json.put("id", id);
		json.put("title", title);
		json.put("body", body);
		json.put("timestamp", timestamp);
		
		String content = json.toString();
		
		mockMvc
			.perform(put(endpoint + "/" + id)
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(id)))
			.andExpect(jsonPath("$.title", is(title)))
			.andExpect(jsonPath("$.body", is(body)))
			.andExpect(jsonPath("$.timestamp", is(timestamp)));
	}
	
	@Test
	public void givenDelete_thenStatus204() throws Exception {
		String id = "33330000-0000-0000-0000-000000000000";/*,
			title = "Lorem ipsum 3", body = "Dolor sit amet 3",
			timestamp = "03-03-2003 03:03:03";
			
		JSONObject json = new JSONObject();
		
		json.put("id", id);
		json.put("title", title);
		json.put("body", body);
		json.put("timestamp", timestamp);
		
		String content = json.toString();*/
		
		mockMvc
			.perform(delete(endpoint + "/" + id)/*
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)*/)
			.andExpect(status().isNoContent());
	}
	
}
