package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

import com.example.domain.Article;

@Repository
public interface IArticleRepository extends MongoRepository<Article, UUID> {
}
