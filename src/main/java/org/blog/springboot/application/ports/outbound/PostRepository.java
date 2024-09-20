package org.blog.springboot.application.ports.outbound;

import org.blog.springboot.domain.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
//    List<Post> findAll();
//    Optional<Post> findById(String id);
//    boolean existsById(String s);
//
//    Post insert(Post post);
    <T extends Post> List<T> insert(Iterable<T> posts);
//
//    Post save(Post post);
//
//    void deleteById(String id);
    void deleteAll();
}
