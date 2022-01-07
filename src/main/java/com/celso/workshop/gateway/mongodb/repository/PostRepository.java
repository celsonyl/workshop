package com.celso.workshop.gateway.mongodb.repository;

import com.celso.workshop.gateway.mongodb.model.PostDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostDatabase, String> {

    List<PostDatabase> getPostDatabasesByUserDatabaseId(String id);
}
