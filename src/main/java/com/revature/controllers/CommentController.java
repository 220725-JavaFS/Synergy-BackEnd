package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Comment;
import com.revature.services.CommentService;

@RestController
@RequestMapping("/comments/{gameId}")
@CrossOrigin
public class CommentController {
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping
	public ResponseEntity<List<Comment>> getCommentsByGameId(@PathVariable int gameId) {
		List<Comment> comments = commentService.findCommentsByGameId(gameId);
		return ResponseEntity.status(HttpStatus.OK).body(comments);
	}
	
	@PostMapping
	public  ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
		Comment dbcomment = commentService.addOrUpdateComment(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbcomment);
	}
	
	@PutMapping
	public  ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
		Comment dbcomment = commentService.addOrUpdateComment(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbcomment);
	}
	
}
