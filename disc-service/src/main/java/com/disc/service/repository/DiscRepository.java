package com.disc.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.disc.service.model.Disc;

@Repository
public interface DiscRepository extends MongoRepository<Disc, Integer> {

}
