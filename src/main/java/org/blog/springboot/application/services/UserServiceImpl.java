package org.blog.springboot.application.services;

import org.blog.springboot.application.ports.inbound.UserService;
import org.blog.springboot.domain.entities.User;
import org.blog.springboot.application.ports.outbound.UserRepository;
import org.blog.springboot.domain.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById() {

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public User insert(User user) {
        return repository.insert(user);
    }

    @Override
    public List<User> insert(List<User> users) {
        return repository.insert(users);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> update(List<User> users) {
        return List.of();
    }
}
