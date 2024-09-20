package org.blog.springboot.infrastructure.adapters.outbound.persistence.mongodb.repositories;

import org.blog.springboot.application.ports.outbound.PostRepository;
import org.blog.springboot.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoPostRepository extends MongoRepository<Post, String>, PostRepository {

    @Override
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitleWithQuery(String text);

    @Override
    @Query("{ $or: [ " +
            "{ 'title': { $regex: ?0, $options: 'i' } }, " +
            "{ 'body': { $regex: ?0, $options: 'i' } }, " +
            "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] }")
    List<Post> findByTextFields(String text);

}
