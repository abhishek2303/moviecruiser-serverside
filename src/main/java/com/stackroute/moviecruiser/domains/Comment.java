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

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Table(name = "COMMENTS")
public class Comment {
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long commentDbId;
	
	@Column(name = "MOVIEDBID", length = 50)
	@NotNull
	private long movieDbId;
	
	@Column(name = "USERDBID", length = 200)
	@NotNull
	private long userDbId;
	
	@Column(name = "COMMENT", length = 200)
    @Size(min = 1, max = 200)
	private String comment;
	
	public Comment() {
		
	}

	public Comment(String comment) {
		super();
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getCommentDbId() {
		return commentDbId;
	}

	public void setCommentDbId(long commentDbId) {
		this.commentDbId = commentDbId;
	}

	public long getMovieDbId() {
		return movieDbId;
	}

	public void setMovieDbId(long movieDbId) {
		this.movieDbId = movieDbId;
	}

	public long getUserDbId() {
		return userDbId;
	}

	public void setUserDbId(long userDbId) {
		this.userDbId = userDbId;
	}
	
}
