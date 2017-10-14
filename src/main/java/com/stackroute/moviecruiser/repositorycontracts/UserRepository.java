package com.stackroute.moviecruiser.repositorycontracts;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.moviecruiser.domains.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{
	
}
