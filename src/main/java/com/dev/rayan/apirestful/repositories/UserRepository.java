package com.dev.rayan.apirestful.repositories;

import com.dev.rayan.apirestful.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> { }
