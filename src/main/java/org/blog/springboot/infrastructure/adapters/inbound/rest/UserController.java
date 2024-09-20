package org.blog.springboot.infrastructure.adapters.inbound.rest;

import org.blog.springboot.application.ports.inbound.UserService;
import org.blog.springboot.domain.entities.Post;
import org.blog.springboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPostsById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok(user.getPosts());
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User newUser = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable String id) {
        User newUser = user;
        newUser.setId(id);
        newUser = service.update(newUser);
        return ResponseEntity.ok(newUser);
    }
}
