package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.service.ArticleService;
import com.example.domain.Article;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping
	public List<Article> read() {
		return service.read();
	}
	
	@GetMapping("/{id}")
	public Article readById(@PathVariable String id) {
		return service.readById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Article create(@RequestBody Article article) {
		return service.create(article);
	}
	
	@PutMapping("/{id}")
	public Article updateById(@PathVariable String id, @RequestBody Article article) {
		return service.updateById(id, article);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable String id) {
		service.deleteById(id);
	}
	
}
