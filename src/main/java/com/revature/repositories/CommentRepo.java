package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	Optional<List<Comment>> findByGameId(int gameId);
}
