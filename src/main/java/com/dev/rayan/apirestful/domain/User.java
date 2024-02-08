package com.dev.rayan.apirestful.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User implements Serializable {

    @EqualsAndHashCode.Include
    private String id;

    private String name;

    @EqualsAndHashCode.Include
    private String email;

}