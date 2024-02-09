package com.dev.rayan.apirestful.resources;

import com.dev.rayan.apirestful.domain.Post;
import com.dev.rayan.apirestful.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService PostService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> readById(@PathVariable String id) {
        Post post = PostService.readById(id);
        return ResponseEntity.ok().body(post);
    }
}
