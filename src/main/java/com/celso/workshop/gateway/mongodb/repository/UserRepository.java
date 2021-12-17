package com.celso.workshop.gateway.mongodb.repository;

import com.celso.workshop.gateway.mongodb.model.UserDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDatabase, String> {
}
