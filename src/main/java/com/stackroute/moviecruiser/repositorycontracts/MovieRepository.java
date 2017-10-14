package com.stackroute.moviecruiser.repositorycontracts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.stackroute.moviecruiser.domains.Movie;

public interface MovieRepository extends MongoRepository<Movie, Long>, MovieRepositoryCustom {
	
}
