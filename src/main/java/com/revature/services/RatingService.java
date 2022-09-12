package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Rating;
import com.revature.models.Users;
import com.revature.repositories.RatingRepo;

@Service
public class RatingService {
	private RatingRepo ratingRepo;

	@Autowired
	public RatingService(RatingRepo ratingRepo) {
		super();
		this.ratingRepo = ratingRepo;
	}

	public List<Rating> findRatingsByGameId(int gameId) {
		Optional<List<Rating>> opt = ratingRepo.findByGameId(gameId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public Rating findRatingByGameIdAndUsersId(int gameId, int usersId ) {
		Optional<Rating> opt = ratingRepo.findByGameIdAndUsersId(gameId, usersId);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
	
	public Rating addOrUpdateRating(Rating rating) {
		return ratingRepo.save(rating);
	}

	public void deleteRatingById(int id) {
		Rating rating = getRatingById(id);
		ratingRepo.delete(rating);
	}

	private Rating getRatingById(int id) {
		Optional<Rating> opt = ratingRepo.findById(id);

		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}
}
