package org.blog.springboot.infrastructure.adapters.inbound.rest;

import org.blog.springboot.application.ports.inbound.PostService;
import org.blog.springboot.domain.entities.Post;
import org.blog.springboot.infrastructure.adapters.inbound.utils.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<Post>> findByTitleOrTextFields(
            @RequestParam(value = "searchTitle", defaultValue = "") String title,
            @RequestParam(value = "searchTextFields", defaultValue = "") String textFields
    ) {
        if (title.isEmpty() && textFields.isEmpty()) {
            return ResponseEntity.ok(List.of());
        }

        List<Post> posts1 = new ArrayList<>();
        if (!title.isEmpty()) {
            title = URL.decodeParam(title);
            posts1 = service.findByTitle(title);
        }

        List<Post> posts2 = new ArrayList<>();
        if (!textFields.isEmpty()) {
            textFields = URL.decodeParam(textFields);
            posts2 = service.findByTextFields(textFields);
        }

        if (title.isEmpty() || textFields.isEmpty()) {
            posts1.addAll(posts2);
            return ResponseEntity.ok(posts1);
        }  else {
            posts1.retainAll(posts2);
            return ResponseEntity.ok(posts1);
        }
    }

}
