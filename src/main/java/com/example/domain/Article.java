package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

@Document(collection = "articles")
public class Article {
	
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
	@Field("timestamp")
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	
	public Article() {
		id = UUID.randomUUID();
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
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", title" + title + ", body=" + body + ", timestamp=" + timestamp + "]";
	}

}
