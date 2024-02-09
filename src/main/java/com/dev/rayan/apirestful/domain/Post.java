package com.dev.rayan.apirestful.domain;

import com.dev.rayan.apirestful.dtos.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
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
}
