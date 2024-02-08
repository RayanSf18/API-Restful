package com.dev.rayan.apirestful.resources;

import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        return ResponseEntity.ok().body(userService.readAll());
    }
}
