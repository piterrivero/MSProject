package com.genre.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.genre.service.model.Genre;

@Repository
public interface GenreRepository extends MongoRepository<Genre, Integer> {

}
