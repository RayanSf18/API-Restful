package com.dev.rayan.apirestful.resources;

import com.dev.rayan.apirestful.domain.Post;
import com.dev.rayan.apirestful.resources.util.URL;
import com.dev.rayan.apirestful.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> readById(@PathVariable String id) {
        Post post = postService.readById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> readByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        String textFormated = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
