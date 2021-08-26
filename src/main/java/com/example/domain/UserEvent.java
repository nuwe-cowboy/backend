package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "userEvents")
public class UserEvent {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	
	@Field("userId")
	private UUID userId;
	@Field("eventId")
	private UUID eventId;
	
	@Field("distance")
	private double distance;
	
	public UserEvent() {
		id = UUID.randomUUID();
	}
	
	public UserEvent(UUID id, UUID userId, UUID eventId, double distance) {
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		this.distance = distance;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public UUID getId() {
		return id;
	}
	
	public UUID getUserId() {
		return userId;
	}
	
	public UUID getEventId() {
		return eventId;
	}
	
	public double getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return "UserEvent [id=" + id + ", userId=" + userId + ", eventId=" + eventId + ", distance=" + distance + "]";
	}
	
}
