package com.stackroute.moviecruiser.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.moviecruiser.domains.Movie;
import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.repositorycontracts.MovieRepository;
import com.stackroute.moviecruiser.servicecontracts.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public List<Movie> getMovies(User user) {
		return getMovies(user.getId());
	}

	@Override
	public List<Movie> getMovies(long userDbId) {
		
		return movieRepository.getMoviesByUserDbId(userDbId);
	}
	
	@Override
	public Movie addMovie(Movie movieEntity) {
		Movie movie = movieRepository.getMovieByUserDbIdAndMovieId(movieEntity.getUserDbId(), movieEntity.getMovieId());
		if(movie == null) return movieRepository.save(movieEntity);
		return movie;
	}

	@Override
	public Movie deleteMovie(long userDbId, long movieId) {
		Movie movie = movieRepository.getMovieByUserDbIdAndMovieId(userDbId, movieId);
		movieRepository.delete(movie.getMovieId());
		return movie;
	}

	@Override
	public Movie deleteMovieByMovieId(long movieDbId) {
		Movie movie = movieRepository.findOne(movieDbId);
		movieRepository.delete(movie);
		return movie;
	}

}
