package org.blog.springboot.application.services;

import org.blog.springboot.application.ports.inbound.PostService;
import org.blog.springboot.application.ports.outbound.PostRepository;
import org.blog.springboot.domain.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Post> insert(List<Post> posts) {
        return repository.insert(posts);
    }
}
