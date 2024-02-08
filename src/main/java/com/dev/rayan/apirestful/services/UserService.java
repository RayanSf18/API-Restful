package com.dev.rayan.apirestful.services;

import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.repositories.UserRepository;
import com.dev.rayan.apirestful.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> readAll() {
        return userRepository.findAll(Sort.by("name").ascending());
    }

    public User readById(String id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Object id=" + id + " not found"));
    }
}
