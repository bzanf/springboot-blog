package org.blog.springboot.application.services;

import org.blog.springboot.application.ports.inbound.UserService;
import org.blog.springboot.application.ports.outbound.UserRepository;
import org.blog.springboot.domain.entities.User;
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
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        if (!repository.existsById(id))
            throw new ObjectNotFoundException("User not found with id: " + id);

        repository.deleteById(id);
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
        User newUser = repository.findById(user.getId())
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + user.getId()));

        updateData(newUser, user);
        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
