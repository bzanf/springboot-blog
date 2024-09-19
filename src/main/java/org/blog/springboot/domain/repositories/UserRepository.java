package org.blog.springboot.domain.repositories;

import org.blog.springboot.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();
    Optional<User> findById();
    User save(User user);
    void deleteById(String id);

}
