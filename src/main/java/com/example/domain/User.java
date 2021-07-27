package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;

@Document(collection = "users")
public class User {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private ObjectId id;
	@Field("name")
	private String name;
	@Field("lastName")
	private String lastName;
	@Field("password")
	@NotBlank(message = "Password is mandatory")
	@Size(min = 8)
	private String password;
	@Field("email")
	@Email(message = "Malformed email address")
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	public User() {
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name" + name + ", lastName=" + lastName + ", password=" + password + ", email=" + email + "]";
	}

}
