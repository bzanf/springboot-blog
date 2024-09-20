package org.blog.springboot.infrastructure.adapters.outbound.tasks;

import org.blog.springboot.application.ports.outbound.PostRepository;
import org.blog.springboot.application.ports.outbound.UserRepository;
import org.blog.springboot.domain.dto.UserSummary;
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
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Eric Gales", "eric@email.com");
        User u2 = new User(null, "Guthrie Govan", "guthrie@email.com");
        User u3 = new User(null, "Samuel L. Jackson", "samuel@email.com");
        User u4 = new User(null, "Kurt Russell", "kurt@email.com");

        userRepository.insert(Arrays.asList(u1, u2, u3, u4));

        Post p1 = new Post(
                null,
                Instant.now(),
                "Building a RESTful API",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                new UserSummary(u3)
        );
        Post p2 = new Post(
                null,
                Instant.now(),
                "I'm playing God of War Ragnarök",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                new UserSummary(u3)
        );

        postRepository.insert(Arrays.asList(p1, p2));

        u3.setPosts(Arrays.asList(p1, p2));

        userRepository.save(u3);
    }
}
