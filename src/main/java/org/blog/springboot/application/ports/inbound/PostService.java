package org.blog.springboot.application.ports.inbound;

import org.blog.springboot.domain.entities.Post;

import java.util.List;

public interface PostService {

    Post findById(String id);
    List<Post> findByTitle(String text);

}
