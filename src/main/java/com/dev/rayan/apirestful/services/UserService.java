package com.dev.rayan.apirestful.services;

import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> readAll() {
        return userRepository.findAll(Sort.by("name").ascending());
    }
}
