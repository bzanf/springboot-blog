package org.blog.springboot.application.services;

import org.blog.springboot.application.ports.inbound.PostService;
import org.blog.springboot.application.ports.outbound.PostRepository;
import org.blog.springboot.domain.entities.Post;
import org.blog.springboot.domain.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public Post findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }
}
