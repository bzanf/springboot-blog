package org.blog.springboot.application.ports.outbound;

import org.blog.springboot.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();
    Optional<User> findById(String id);
    boolean existsById(String s);

    User insert(User user);
    <T extends User> List<T> insert(Iterable<T> users);

    User save(User user);

    void deleteById(String id);
    void deleteAll();

}
