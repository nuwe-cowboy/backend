package com.example.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "events")
public class Event {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	@Field("title")
	@NotBlank(message = "Title is mandatory")
	private String title;
	@Field("body")
	@NotBlank(message = "Body is mandatory")
	private String body;
	@Field("goal")
	@NotNull(message = "Goal is mandatory")
	private double goal;
	@Field("timestamp")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	
	public Event() {
		id = UUID.randomUUID();
	}
	
	public Event(UUID id, String title, String body, int goal, LocalDateTime timestamp) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.goal = goal;
		this.timestamp = timestamp;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void setGoal(double goal) {
		this.goal = goal;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getBody() {
		return body;
	}
	
	public double getGoal() {
		return goal;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", body=" + body + ", goal=" + goal + ", timestamp=" + timestamp + "]";
	}

}
