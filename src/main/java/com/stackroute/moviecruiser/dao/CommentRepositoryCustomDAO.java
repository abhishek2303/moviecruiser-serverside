package com.stackroute.moviecruiser.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.stackroute.moviecruiser.domains.Comment;
import com.stackroute.moviecruiser.domains.Movie;
import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.repositorycontracts.CommentRepositoryCustom;

@Repository
public class CommentRepositoryCustomDAO implements CommentRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Comment> getCommentsByUserDbIdAndMovieDbId(long userDbId, long movieDbId) {
		String sql = "select comment from comments where userdbid=" + userDbId + " and moviedbid=" + movieDbId;
		javax.persistence.Query query = em.createQuery(sql);
	    return query.getResultList();
	}

}
