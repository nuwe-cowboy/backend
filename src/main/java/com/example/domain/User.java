package com.example.domain;

public class User {
	
	private String id;
	private String name;
	private String lastName;
	private String password;
	private String email;
	
	public void setId(String id) {
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
		return id;
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
		return "User[id=" + id + ", name" + name + ", lastName=" + lastName + ", password=" + password + ", email=" + email + "]";
	}

}
