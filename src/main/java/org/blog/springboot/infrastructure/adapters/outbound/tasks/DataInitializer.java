package org.blog.springboot.infrastructure.adapters.outbound.tasks;

import org.blog.springboot.application.ports.outbound.PostRepository;
import org.blog.springboot.application.ports.outbound.UserRepository;
import org.blog.springboot.domain.dto.UserSummary;
import org.blog.springboot.domain.entities.Comment;
import org.blog.springboot.domain.entities.Post;
import org.blog.springboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;

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

        userRepository.insert(List.of(u1, u2, u3, u4));

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

        Comment c1 = new Comment("Yes no yes no yes no yes no", Instant.now(), new UserSummary(u2));
        Comment c2 = new Comment("Top bottom top bottom top bottom", Instant.now(), new UserSummary(u3));
        Comment c3 = new Comment("Right left right wrong right left", Instant.now(), new UserSummary(u2));

        p1.setComments(List.of(c1,c2));
        p2.setComments(List.of(c3));

        postRepository.insert(List.of(p1, p2));

        u3.setPosts(List.of(p1, p2));

        userRepository.save(u3);
    }
}
