package com.example.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Article;

@Repository
public interface IArticleRepository extends MongoRepository<Article, UUID> {
}
