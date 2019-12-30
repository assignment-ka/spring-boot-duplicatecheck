package com.example.duplicatecheck.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.duplicatecheck.model.OpaqueToken;

@RepositoryRestResource(collectionResourceRel = "key", path = "key")
public interface OpaqueTokenRepositoryAssignment extends MongoRepository<OpaqueToken, String> {

  public OpaqueToken findByValue(@Param("value") String value);

}