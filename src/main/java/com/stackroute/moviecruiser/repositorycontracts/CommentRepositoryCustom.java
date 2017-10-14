package com.stackroute.moviecruiser.repositorycontracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stackroute.moviecruiser.domains.Comment;

@Repository
public interface CommentRepositoryCustom {
	List<Comment> getCommentsByUserDbIdAndMovieDbId(long userDbId, long movieDbId);
}
