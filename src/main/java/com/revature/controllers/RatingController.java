package com.revature.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.revature.models.Rating;
import com.revature.services.RatingService;

@RestController
@RequestMapping("/ratings")
@CrossOrigin
public class RatingController {
	private RatingService ratingService;
	private static Logger log = LoggerFactory.getLogger(RatingController.class);
	@Autowired
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}
	
	@GetMapping("/{gameId}")
	public ResponseEntity<List<Rating>> getRatingsByGameId(@PathVariable int gameId) {
		List<Rating> ratings = ratingService.findRatingsByGameId(gameId);
		log.info(ratings.toString());
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@GetMapping("/{gameId}/{usersId}")
	public ResponseEntity<Rating> getRatingsByGameIdAndUsers(@PathVariable int gameId, @PathVariable int usersId) {
		Rating rating = ratingService.findRatingByGameIdAndUsersId(gameId, usersId);
		log.info(rating.toString());
		if(rating == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(rating);
		}
		return ResponseEntity.status(HttpStatus.OK).body(rating);
	}
	
	
	@PostMapping
	public  ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating dbrating = ratingService.addOrUpdateRating(rating);
		log.info(dbrating.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(dbrating);
	}
	
	@PutMapping
	public  ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
		Rating dbrating = ratingService.addOrUpdateRating(rating);
		log.info(dbrating.toString());
		return ResponseEntity.status(HttpStatus.OK).body(dbrating);
	}
	
}