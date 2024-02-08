package com.dev.rayan.apirestful.resources;

import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.dtos.UserDTO;
import com.dev.rayan.apirestful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody UserDTO userDTO) {
        User user = userService.fromDTO(userDTO);
        user = userService.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri(); // Gets the path of the created resource
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> readAll() {
        List<User> userList = userService.readAll();
        List<UserDTO> userDTOList = userList.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> readById(@PathVariable String id) {
        UserDTO userDTO = new UserDTO(userService.readById(id));
        return ResponseEntity.ok().body(userDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        User user = userService.fromDTO(userDTO);
        user.setId(id);
        user = userService.update(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
