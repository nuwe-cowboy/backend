package com.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.bson.types.ObjectId;

@Document(collection = "users")
public class User {
	
	@MongoId
	@Field(name = "_id")
	private ObjectId id;
	@Field(name = "name")
	private String name;
	@Field(name = "lastName")
	private String lastName;
	@Field(name = "password")
	private String password;
	@Field(name = "email")
	private String email;
	
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
