package com.stackroute.moviecruiser.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.stackroute.moviecruiser.domains.Movie;
import com.stackroute.moviecruiser.repositorycontracts.MovieRepositoryCustom;

public class MovieRepositoryCustomDAO implements MovieRepositoryCustom {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> getMoviesByUserDbId(long userDbId) {
		String sql = "select comment from comments where userdbid=" + userDbId;
		javax.persistence.Query query = em.createQuery(sql);
	    return query.getResultList();
	}

	@Override
	public Movie getMovieByUserDbIdAndMovieId(long userDbId, long movieId) {
		String sql = "select comment from comments where userdbid=" + userDbId + " and " + "movieid=" + movieId;
		javax.persistence.Query query = em.createQuery(sql);
		List<Movie> movies = query.getResultList();
		if(movies.size() == 0) return null;
		return movies.get(0);
	}

	
}
