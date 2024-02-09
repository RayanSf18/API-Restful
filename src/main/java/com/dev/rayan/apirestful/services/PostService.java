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
    private PostRepository postRepository;

    public Post readById(String id) {
        Optional<Post> optional = postRepository.findById(id);
        return optional.orElseThrow(() -> new ObjectNotFoundException("Object id=" + id + " not found"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

}
