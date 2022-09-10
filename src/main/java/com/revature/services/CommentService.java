package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Comment;
import com.revature.repositories.CommentRepo;

@Service
public class CommentService {

	private CommentRepo commentRepo;

	@Autowired
	public CommentService(CommentRepo commentRepo) {
		super();
		this.commentRepo = commentRepo;
	}

	public List<Comment> findCommentsByGameId(int gameId) {
		Optional<List<Comment>> opt = commentRepo.findByGameId(gameId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public Comment addOrUpdateComment(Comment comment) {
		return commentRepo.save(comment);
	}

	public void deleteCommentById(int id) {
		Comment comment = getCommentById(id);
		commentRepo.delete(comment);
	}

	private Comment getCommentById(int id) {
		Optional<Comment> opt = commentRepo.findById(id);
		
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
	
}
