package com.dev.rayan.apirestful.dtos;

import com.dev.rayan.apirestful.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;
    private String password;

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
    }

}