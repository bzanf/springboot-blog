package org.blog.springboot.application.ports.outbound;

import org.blog.springboot.domain.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    Optional<Post> findById(String id);
    List<Post> findByTitleContainingIgnoreCase(String text);
    List<Post> findByTitleWithQuery(String text);

    <T extends Post> List<T> insert(Iterable<T> posts);

    void deleteAll();
}
