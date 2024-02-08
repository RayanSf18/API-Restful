package com.dev.rayan.apirestful.resources;

import com.dev.rayan.apirestful.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> readAll() {
        User u1 = new User("1", "Maria Brown", "maria@gmail.com");
        User u2 = new User("2", "Pedro Brown", "pedro@gmail.com");
        User u3 = new User("3", "Ricardo Brown", "ricardo@gmail.com");
        return ResponseEntity.ok().body(Arrays.asList(u1, u2, u3));
    }
}
