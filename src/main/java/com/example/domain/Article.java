package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

@Document(collection = "articles")
public class Article {
	
	@MongoId
	@Field(name = "_id")
	private ObjectId id;
	@Field(name = "title")
	private String title;
	@Field(name = "body")
	private String body;
	@Field(name = "timestamp")
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
