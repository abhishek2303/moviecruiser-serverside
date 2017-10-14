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
import com.stackroute.moviecruiser.serviceimpl.CommentServiceImpl;

@RestController
public class CommentsController implements BaseURI {
	//Injects comments service
	@Autowired
	private CommentServiceImpl commentService;
	
	@PostMapping(value = {"/comment"})
	public @ResponseBody ResponseEntity addComment(RequestEntity<Comment> request) {
		Comment commentToAdd = request.getBody();
		
		//TODO: Check if service successfully adds the comment
		try {
			commentToAdd = commentService.addComment(commentToAdd);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Unable to save comment", HttpStatus.CONFLICT);
		}
		ResponseEntity<Comment> response = new ResponseEntity<Comment> (commentToAdd, HttpStatus.OK);
		
		return response;
	}
	
	@GetMapping(value = {"/comments"})
	public @ResponseBody ResponseEntity comments(@RequestParam(value="user", required = true) long userDbId,
			@RequestParam(value="movie", required = true) long movieDbId) {
		
		List<Comment> comments = null;
		
		try {
			comments = commentService.getComments(userDbId, movieDbId);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Unable to retrieve comments", HttpStatus.CONFLICT);
		}
		ResponseEntity<Comment> response = new ResponseEntity (comments, HttpStatus.OK);
		
		return response;
	}
	
	@DeleteMapping(value="/comment/delete")
	public ResponseEntity deleteComment(RequestEntity<Comment> reqCommentId) {
		Comment commentToDelete = reqCommentId.getBody();
		
		long commentDbId = commentToDelete.getCommentDbId();
		
		System.out.println(commentDbId);
		
		try {
			commentService.deleteComment(commentDbId);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Unable to delete user", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Comment>(commentToDelete, HttpStatus.OK);
	}
	
	@GetMapping(value = {"/randomcomment"})
	public @ResponseBody ResponseEntity<Comment> comments() {
		Comment comment = new Comment();
		comment.setComment("");
		comment.setCommentDbId(0L);
		comment.setMovieDbId(0L);
		comment.setUserDbId(0L);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	
}
