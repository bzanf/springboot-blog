package org.blog.springboot.application.ports.outbound;

import org.blog.springboot.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    Optional<User> findById(String id);

    User insert(User user);
    <T extends User> List<T> insert(Iterable<T> users);

    User save(User user);
    <T extends User> List<T> save(Iterable<T> users);

    void deleteById(String id);
    void deleteAll();
}
