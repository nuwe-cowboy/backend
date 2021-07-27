package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.bson.types.ObjectId;

@Document(collection = "articles")
public class Article {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private ObjectId id;
	@Field("title")
	@NotBlank(message = "Title is mandatory")
	private String title;
	@Field("body")
	@NotBlank(message = "Body is mandatory")
	private String body;
	@Field("timestamp")
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	public Article() {
	}
	
	public void setId(ObjectId id) {
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
	
	public String getId() {
		return id.toString();
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
