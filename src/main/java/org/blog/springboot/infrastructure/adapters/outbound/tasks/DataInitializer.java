package org.blog.springboot.infrastructure.adapters.outbound.tasks;

import org.blog.springboot.application.ports.inbound.UserService;
import org.blog.springboot.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.deleteAll();

        User u1 = new User(null, "Eric Gales", "eric@email.com");
        User u2 = new User(null, "Guthrie Govan", "guthrie@email.com");
        User u3 = new User(null, "Samuel L. Jackson", "samuel@email.com");
        User u4 = new User(null, "Kurt Russell", "kurt@email.com");

        userService.insert(Arrays.asList(u1, u2, u3, u4));
    }
}
