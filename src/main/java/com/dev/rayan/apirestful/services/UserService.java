package com.dev.rayan.apirestful.services;

import com.dev.rayan.apirestful.domain.Post;
import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.dtos.UserDTO;
import com.dev.rayan.apirestful.repositories.UserRepository;
import com.dev.rayan.apirestful.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public User create(User newUser) {
        return userRepository.insert(newUser);
    }

    // READs
    public List<User> readAll() {
        return userRepository.findAll(Sort.by("name").ascending());
    }

    public User readById(String id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Object id=" + id + " not found"));
    }

    // UPDATE
    public User update(User updatedUserData) {
        Optional<User> existingUser = userRepository.findById(updatedUserData.getId());
        updateData(existingUser.get(), updatedUserData);
        return userRepository.save(existingUser.get());
    }

    private void updateData(User userExisted, User dataUpdated) {
        userExisted.setName(dataUpdated.getName());
        userExisted.setEmail(dataUpdated.getEmail());
    }

    // DELETE
    public void deleteById(String id) {
        readById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
    }

}
