package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;

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
	
	public Article readById(String id) {
		return repository.findById(new ObjectId(id)).orElseThrow(() -> new ResourceNotFoundException("Article with id=" + id + " not found in database"));
	}
	
	public Article create(Article article) {
		article.setTimestamp(LocalDateTime.now());
		return repository.save(article);
	}
	
	public Article updateById(String id, Article article) {
		article.setId(new ObjectId(id));
		return repository.save(article);
	}
	
	public void deleteById(String id) {
		repository.deleteById(new ObjectId(id));
	}
	
}
