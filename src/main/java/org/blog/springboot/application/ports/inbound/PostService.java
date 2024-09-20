package org.blog.springboot.application.ports.inbound;

import org.blog.springboot.domain.entities.Post;

import java.util.List;

public interface PostService {

//    User findById(String id);
//    List<User> findAll();
//
//    void deleteById(String id);
    void deleteAll();
//
//    Post insert(Post post);
    List<Post> insert(List<Post> posts);
//
//    User update(Post post);
//    List<Post> update(List<Post> posts);

}
