package com.stackroute.moviecruiser.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MOVIES")
public class Movie {
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long movieDbId;
	
	/*
	 * MOVIEID: Id as in in TMDB movie database
	 */
	@Column(name = "MOVIEID", length = 10, unique = true)
	@NotNull
	private long movieId;
	
	@Column(name = "MOVIENAME", length = 50, unique = true)
    @Size(min = 2, max = 50)
	@NotNull
	private String movieName;
	
	@Column(name = "USERID", length = 50, unique = true)
	@NotNull
	private long userDbId;
	
	public Movie() {
		
	}
	
	public Movie(int movieId) {
		this.movieId = movieId;
	}
	
	public long getMovieDbId() {
		return this.movieDbId;
	}
	public void setMovieDbId(long movieDbId) {
		this.movieDbId = movieDbId;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public long getUserDbId() {
		return this.userDbId;
	}
	public void setUserDbId(long userDbId) {
		this.userDbId = userDbId;
	}
	
}
