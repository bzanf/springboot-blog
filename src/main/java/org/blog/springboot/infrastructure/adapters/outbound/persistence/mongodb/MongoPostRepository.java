package org.blog.springboot.infrastructure.adapters.outbound.persistence.mongodb;

import org.blog.springboot.application.ports.outbound.PostRepository;
import org.blog.springboot.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPostRepository extends MongoRepository<Post, String>, PostRepository {
}
