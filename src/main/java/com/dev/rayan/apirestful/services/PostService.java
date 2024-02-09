package com.dev.rayan.apirestful.services;

import com.dev.rayan.apirestful.domain.Post;
import com.dev.rayan.apirestful.repositories.PostRepository;
import com.dev.rayan.apirestful.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository PostRepository;

    public Post readById(String id) {
        Optional<Post> optional = PostRepository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Object id=" + id + " not found"));
    }


}
