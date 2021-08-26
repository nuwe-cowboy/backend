package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.example.domain.Article;
import com.example.domain.ERole;
import com.example.domain.Event;
import com.example.domain.User;
import com.example.repository.IArticleRepository;
import com.example.repository.IEventRepository;
import com.example.repository.IUserRepository;

@SpringBootApplication
public class App {
	
	@Autowired
	private IArticleRepository articleRepository;
	
	@Autowired
	private IEventRepository eventRepository;
	
	@Autowired
	private IUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	@Profile("test")
	public ApplicationRunner loadData() {
		return args -> {
			this.loadArticles();
			this.loadEvents();
			this.loadUsers();
		};
	}
	
	private void loadArticles() {
		articleRepository.deleteAll();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		articleRepository.save(new Article(UUID.fromString("11110000-0000-0000-0000-000000000000"), "Lorem ipsum 1", "Dolor sit amet 1", LocalDateTime.parse("01-01-2001 01:01:01", formatter)));
		articleRepository.save(new Article(UUID.fromString("22220000-0000-0000-0000-000000000000"), "Lorem ipsum 2", "Dolor sit amet 2", LocalDateTime.parse("02-02-2002 02:02:02", formatter)));
		articleRepository.save(new Article(UUID.fromString("33330000-0000-0000-0000-000000000000"), "Lorem ipsum 3", "Dolor sit amet 3", LocalDateTime.parse("03-03-2003 03:03:03", formatter)));
	}
	
	private void loadEvents() {
		eventRepository.deleteAll();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		eventRepository.save(new Event(UUID.fromString("11110000-0000-0000-0000-000000000000"), "Lorem ipsum 1", "Dolor sit amet 1", 100, LocalDateTime.parse("01-01-2001 01:01:01", formatter)));
		eventRepository.save(new Event(UUID.fromString("22220000-0000-0000-0000-000000000000"), "Lorem ipsum 2", "Dolor sit amet 2", 200, LocalDateTime.parse("02-02-2002 02:02:02", formatter)));
		eventRepository.save(new Event(UUID.fromString("33330000-0000-0000-0000-000000000000"), "Lorem ipsum 3", "Dolor sit amet 3", 300, LocalDateTime.parse("03-03-2003 03:03:03", formatter)));
	}
	
	private void loadUsers() {
		userRepository.deleteAll();
		
		userRepository.save(new User(UUID.fromString("11110000-0000-0000-0000-000000000000"), "John", "Doe", "john@example.com", "$2a$10$4bNJAICKUh8USNvKmSICwud3vkb6ZwVgwDdNY.mWexqcNs4ZdIzrS", ERole.DEFAULT));
		userRepository.save(new User(UUID.fromString("22220000-0000-0000-0000-000000000000"), "Jane", "Doe", "jane@example.com", "$2a$10$JUs4hN/U73Hrcbf6LV3aW.sZcUTbcVLrcuG5FwDVYsfiRo2afgJ7O", ERole.ADMIN));
		userRepository.save(new User(UUID.fromString("33330000-0000-0000-0000-000000000000"), "George", "O'Malley", "george@example.com", "$2a$10$dek627gZNaA8MbmUSrLQceLd6YGbvwZlUrO.lks8JMZFdY9RfyHaG", ERole.DEFAULT));
	}

}
