package com.dev.rayan.apirestful.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Document(collection = "user")
public class User implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private String name;

    @EqualsAndHashCode.Include
    private String email;

    private String password;

    @Setter(value = AccessLevel.NONE)
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}