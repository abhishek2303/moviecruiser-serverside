package com.stackroute.moviecruiser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.moviecruiser.domains.Comment;
import com.stackroute.moviecruiser.domains.Movie;
import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.serviceimpl.MovieServiceImpl;

@RestController
public class MoviesController implements BaseURI{
	@Autowired
	private MovieServiceImpl movieService;
	
	@PostMapping(value = {"/movie"})
	public @ResponseBody ResponseEntity addMovie(RequestEntity<Movie> request) {
		Movie movieToAdd = request.getBody();
		
		
		//TODO: Check if service successfully adds the comment
		try {
			movieToAdd = movieService.addMovie(movieToAdd);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Unable to save comment", HttpStatus.CONFLICT);
		}
		ResponseEntity<Movie> response = new ResponseEntity<Movie> (movieToAdd, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping(value = {"/movies"})
	public @ResponseBody ResponseEntity movies(@RequestParam(value="user", required = true) long userDbId) {
		
		List<Movie> movies = null;
		
		try {
			movies = movieService.getMovies(userDbId);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Unable to retrieve movies for the particular user", HttpStatus.CONFLICT);
		}
		ResponseEntity<Movie> response = new ResponseEntity (movies, HttpStatus.OK);
		
		return response;
	}
	
	@DeleteMapping(value="/movie/deletemovie")
	public ResponseEntity deleteMovie(RequestEntity<Movie> reqMovieId) {
		Movie movieToDelete = reqMovieId.getBody();
		
		long movieDbId = movieToDelete.getMovieDbId();
		
		System.out.println(movieDbId);
		
		try {
			movieToDelete = movieService.deleteMovieByMovieId(movieDbId);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Unable to delete user", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Movie>(movieToDelete, HttpStatus.OK);
	}
	
	
	@GetMapping(value = {"/randommovie"})
	public @ResponseBody ResponseEntity<Movie> getMovieFormat() {
		Movie movie = new Movie();
		movie.setMovieDbId(0L);
		movie.setMovieId(0);
		movie.setMovieName("");
		movie.setUserDbId(0L);;
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
}
