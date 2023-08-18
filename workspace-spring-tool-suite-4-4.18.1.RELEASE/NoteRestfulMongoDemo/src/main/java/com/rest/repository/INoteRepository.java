package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.Note;
@Repository
public interface INoteRepository extends MongoRepository<Note, Integer> {

}
