package com.stackroute.moviecruiser.repositorycontracts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.moviecruiser.domains.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>, CommentRepositoryCustom {
	
}
