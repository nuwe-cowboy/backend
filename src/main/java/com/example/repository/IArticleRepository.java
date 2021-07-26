package com.example.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

import com.example.domain.Article;

@Repository
public interface IArticleRepository extends MongoRepository<Article, ObjectId> {
}
