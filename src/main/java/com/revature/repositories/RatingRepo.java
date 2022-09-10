package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
	Optional<List<Rating>> findByGameId(int gameId);
}
