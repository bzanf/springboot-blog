package org.blog.springboot.application.ports.inbound;

import org.blog.springboot.domain.entities.User;

import java.util.List;

public interface UserService {

    User findById(String id);
    List<User> findAll();

    void deleteById(String id);
    void deleteAll();

    User insert(User user);
    List<User> insert(List<User> users);

    User update(User user);

}
