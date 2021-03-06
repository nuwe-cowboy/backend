package com.example.domain;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "users")
public class User {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	@Field("name")
	private String name;
	@Field("lastName")
	private String lastName;
	@Field("email")
	@Email(message = "Malformed email address")
	@NotBlank(message = "Email is mandatory")
	@Indexed(unique = true)
	private String email;
	@Field("password")
	@NotBlank(message = "Password is mandatory")
	@Size(min = 6, message = "Size must be greater than or equal to 8")
	private String password;
	@Field("role")
	private ERole role;
	
	public User() {
		id = UUID.randomUUID();
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(ERole role) {
		this.role = role;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ERole getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name" + name + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}

}
