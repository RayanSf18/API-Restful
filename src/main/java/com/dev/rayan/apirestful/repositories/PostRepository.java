package com.dev.rayan.apirestful.repositories;

import com.dev.rayan.apirestful.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { }
