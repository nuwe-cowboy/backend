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
import com.example.repository.IArticleRepository;

@SpringBootApplication
public class App {
	
	@Autowired
	private IArticleRepository articleRepository;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
	@Profile("test")
	public ApplicationRunner loadData() {
		return args -> {
			this.loadArticles();
		};
	}
	
	private void loadArticles() {
		articleRepository.deleteAll();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		articleRepository.save(new Article(UUID.fromString("11110000-0000-0000-0000-000000000000"), "Lorem ipsum 1", "Dolor sit amet 1", LocalDateTime.parse("01-01-2001 01:01:01", formatter)));
		articleRepository.save(new Article(UUID.fromString("22220000-0000-0000-0000-000000000000"), "Lorem ipsum 2", "Dolor sit amet 2", LocalDateTime.parse("02-02-2002 02:02:02", formatter)));
		articleRepository.save(new Article(UUID.fromString("33330000-0000-0000-0000-000000000000"), "Lorem ipsum 3", "Dolor sit amet 3", LocalDateTime.parse("03-03-2003 03:03:03", formatter)));
	}

}
