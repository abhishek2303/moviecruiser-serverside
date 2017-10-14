package com.stackroute.moviecruiser.repositorycontracts;

import java.util.List;

import com.stackroute.moviecruiser.domains.Movie;

public interface MovieRepositoryCustom {
	public List<Movie> getMoviesByUserDbId(long userDbId);
	public Movie getMovieByUserDbIdAndMovieId(long userDbId, long movieId);
}
