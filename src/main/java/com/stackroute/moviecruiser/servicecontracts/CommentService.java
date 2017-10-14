package com.stackroute.moviecruiser.servicecontracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.moviecruiser.domains.Comment;

@Service
public interface CommentService {
	public List<Comment> getComments(long userDbId, long movieDbId);
	public Comment addComment(Comment comment);
	public Comment deleteComment(long commentDbId);
}
