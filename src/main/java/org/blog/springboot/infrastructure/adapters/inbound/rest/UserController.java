package org.blog.springboot.infrastructure.adapters.inbound.rest;

import org.blog.springboot.domain.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAlList() {
        User u1 = new User("1", "Steve Vai", "steve@email.com");
        User u2 = new User("1", "Eric Gales", "ericgales@email.com");

        return ResponseEntity.ok(new ArrayList<>(Arrays.asList(u1, u2)));
    }
}
