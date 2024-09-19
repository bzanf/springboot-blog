package org.blog.springboot.infrastructure.adapters.outbound.persistence.mongodb;

import org.blog.springboot.domain.entities.User;
import org.blog.springboot.domain.repositories.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserRepository extends MongoRepository<User, String>, UserRepository {
}
