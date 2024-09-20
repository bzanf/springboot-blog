package org.blog.springboot.infrastructure.adapters.outbound.tasks;

import org.blog.springboot.application.ports.inbound.PostService;
import org.blog.springboot.application.ports.inbound.UserService;
import org.blog.springboot.domain.entities.Post;
import org.blog.springboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
        userService.deleteAll();
        postService.deleteAll();

        User u1 = new User(null, "Eric Gales", "eric@email.com");
        User u2 = new User(null, "Guthrie Govan", "guthrie@email.com");
        User u3 = new User(null, "Samuel L. Jackson", "samuel@email.com");
        User u4 = new User(null, "Kurt Russell", "kurt@email.com");

        Post p1 = new Post(
                null,
                Instant.now(),
                "Building a RESTful API",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                u3
        );
        Post p2 = new Post(
                null,
                Instant.now(),
                "I'm playing God of War Ragnarök",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                u3
        );

        userService.insert(Arrays.asList(u1, u2, u3, u4));
        postService.insert(Arrays.asList(p1, p2));
    }
}
