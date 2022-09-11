package com.VideoGame.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VideoGame.Models.Game;
import com.VideoGame.Repositories.GameRepository;

/*
 * Indicates that an annotated class is a "Service", originally defined by 
 * Domain-Driven Design (Evans, 2003) as "an operation offered as an interface 
 * that stands alone in the model, with no encapsulated state."
 */
@Service
public class GameService {
	private GameRepository GR;
	
	@Autowired
	public GameService(GameRepository GR) {
		super();
		this.GR = GR;
	}
	
	public List<Game> findGamesById(int gameID){
		Optional<List <Game>> Option = GR.findByGameId(gameID);
		if(Option.isPresent()) {
			return Option.get();
		} else {
			return null;
		}
	}

}
