package com.dev.rayan.apirestful.domain;

import com.dev.rayan.apirestful.dtos.AuthorDTO;
import com.dev.rayan.apirestful.dtos.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Post implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private Date date;
    private String title;
    private String body;

    private AuthorDTO author;

    @Setter(value = AccessLevel.NONE)
    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}