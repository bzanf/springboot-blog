package org.blog.springboot.infrastructure.adapters.outbound.persistence.mongodb.repositories;

import org.blog.springboot.application.ports.outbound.UserRepository;
import org.blog.springboot.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserRepository extends MongoRepository<User, String>, UserRepository {
}