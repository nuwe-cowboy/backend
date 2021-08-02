package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.IArticleRepository;
import com.example.domain.Article;
import com.example.controller.exception.ResourceNotFoundException;

@Service
public class ArticleService {
	
	@Autowired
	private IArticleRepository repository;
	
	public List<Article> read() {
		return repository.findAll();
	}
	
	public Article readById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article with id=" + id + " not found in database"));
	}
	
	public Article create(Article article) {
		article.setTimestamp(LocalDateTime.now());
		return repository.save(article);
	}
	
	public Article updateById(UUID id, Article article) {
		article.setId(id);
		return repository.save(article);
	}
	
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}
	
}
