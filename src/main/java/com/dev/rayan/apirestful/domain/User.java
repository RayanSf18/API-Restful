package com.dev.rayan.apirestful.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
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

}