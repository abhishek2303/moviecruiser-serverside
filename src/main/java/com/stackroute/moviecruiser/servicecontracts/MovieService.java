package com.stackroute.moviecruiser.servicecontracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.moviecruiser.domains.Movie;
import com.stackroute.moviecruiser.domains.User;

@Service
public interface MovieService {
	public List<Movie> getMovies(User user);
	public List<Movie> getMovies(long userDbId);
	public Movie deleteMovie(long userDbId, long movieId);
	public Movie deleteMovieByMovieId(long movieDbId);
	public Movie addMovie(Movie movie);
}
