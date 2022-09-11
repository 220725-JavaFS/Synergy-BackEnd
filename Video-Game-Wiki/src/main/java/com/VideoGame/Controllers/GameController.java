package com.VideoGame.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VideoGame.Exceptions.ResourceNotFoundException;
import com.VideoGame.Models.Game;
import com.VideoGame.Repositories.GameRepository;

/*		NOTES
 * @VALIDATED - Variant of JSR-303's javax.validation.Valid, supporting the 
 * specification of validation groups. Designed for convenient use with 
 * Spring's JSR-303 support but not JSR-303 specific.
 * 
 * JSR-303:
 * JSR-303 standardizes validation constraint declaration and metadata for
 * the Java platform. Using this API, you annotate domain model properties 
 * with declarative validation constraints and the runtime enforces them. 
 * There are a number of built-in constraints you can can take advantage of. 
 * You may also define your own custom constraints.
 * 
 * CrossOrigin
 * Annotation for permitting cross-origin requests on specific handler 
 * classes and/or handler methods. Processed if an appropriate HandlerMapping 
 * is configured.
 */

@RestController
@RequestMapping("https://api.igdb.com/v4")
@CrossOrigin
public class GameController {
	@Autowired
	private GameRepository GR;
	
	//Get Games
	@GetMapping("/games/?fields=*")
	public List<Game> getAllGames(){
		return GR.findAll();
	}
	
//	Get Game By Id
	@GetMapping("/games/{id}/?fields=*")
	public ResponseEntity<Game> getGameById(@PathVariable(value = "id") Long gameId) 
			throws ResourceNotFoundException{
		Game game = GR.findById(gameId).orElseThrow(() -> 
		new ResourceNotFoundException("Game Not Found For This Id :: " + gameId));
		return ResponseEntity.ok().body(game);
	}
	
	@PostMapping("/games/{id}/?fields=*") // - NOT FOR POSTING
	public Game createGame(@Validated @RequestBody Game CreateGame){
		return GR.save(CreateGame);
	}
	
	@PutMapping("/games/{id}")
	public ResponseEntity<Game> updateGame(@PathVariable(value = "id") Long gameId,
			@Validated @RequestBody Game gameDetails) throws ResourceNotFoundException {
		Game game = GR.findById(gameId)
				.orElseThrow(() -> new ResourceNotFoundException("Game Not Found For This Id :: " + gameId));

		game.setName(gameDetails.getName());
		game.setGenres(gameDetails.getGenres());
		game.setGame_modes(gameDetails.getGame_modes());
		final Game updatedGame = GR.save(game);
		return ResponseEntity.ok(updatedGame);
	}

	@DeleteMapping("/games/{id}")
	public Map<String, Boolean> deleteGame(@PathVariable(value = "id") Long gameId)
			throws ResourceNotFoundException {
		Game game = GR.findById(gameId)
				.orElseThrow(() -> new ResourceNotFoundException("Game Not Found For This Id :: " + gameId));

		GR.delete(game);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
