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

import com.revature.models.Rating;
import com.revature.services.RatingService;

@RestController
@RequestMapping("/ratings/{gameId}")
@CrossOrigin
public class RatingController {
	private RatingService ratingService;
	
	@Autowired
	public RatingController(RatingService ratingService) {
		super();
		this.ratingService = ratingService;
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatingsByGameId(@PathVariable int gameId) {
		List<Rating> ratings = ratingService.findRatingsByGameId(gameId);
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@PostMapping
	public  ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating dbrating = ratingService.addOrUpdateRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbrating);
	}
	
	@PutMapping
	public  ResponseEntity<Rating> updateRating(@RequestBody Rating rating) {
		Rating dbrating = ratingService.addOrUpdateRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(dbrating);
	}
	
}