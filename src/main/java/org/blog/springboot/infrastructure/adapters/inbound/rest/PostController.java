package org.blog.springboot.infrastructure.adapters.inbound.rest;

import org.blog.springboot.application.ports.inbound.PostService;
import org.blog.springboot.domain.entities.Post;
import org.blog.springboot.infrastructure.adapters.inbound.utils.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "searchTitle", defaultValue = "") String text) {
        if (text.isEmpty()) {
            return ResponseEntity.ok(List.of());
        }

        text = URL.decodeParam(text);
        List<Post> posts = service.findByTitle(text);
        return ResponseEntity.ok(posts);
    }

}
