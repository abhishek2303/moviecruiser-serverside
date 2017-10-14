package com.stackroute.moviecruiser.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.moviecruiser.domains.Comment;
import com.stackroute.moviecruiser.domains.Movie;
import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.repositorycontracts.CommentRepository;
import com.stackroute.moviecruiser.repositorycontracts.MovieRepository;
import com.stackroute.moviecruiser.servicecontracts.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getComments(long userDbId, long movieDbId) {
		return commentRepository.getCommentsByUserDbIdAndMovieDbId(userDbId, movieDbId);
	}
	
	@Override
	public Comment addComment(Comment comment) {
		Comment commentObj = comment;
		
		try {
			commentObj = commentRepository.save(comment);
		} catch(Exception e) {
			throw e;
		}
		return commentObj;
	}

	@Override
	public Comment deleteComment(long commentId) {
		Comment comment = commentRepository.findOne(commentId);
		commentRepository.delete(commentId);
		return comment;
	}

}
