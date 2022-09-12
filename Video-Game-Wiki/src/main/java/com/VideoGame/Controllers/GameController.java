package com.VideoGame.Controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.client.RestTemplate;

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
 * 
 * RestTemplate
 * Synchronous client to perform HTTP requests, exposing a simple, template 
 * method API over underlying HTTP client libraries such as the JDK 
 * HttpURLConnection, Apache HttpComponents, and others.
 */

@RestController
@RequestMapping("https://api.igdb.com/v4/games")
@CrossOrigin
public class GameController {
	@Autowired
	private GameRepository GR;
	
	//Get Games
	@GetMapping("/?fields=*")
	public List<Game> getAllGames(){
		return GR.findAll();
	}
	
//	Get Game By Id .. there is abstraction going on with using ReponseEntity
	@GetMapping("/{id}/?fields=*")
	public ResponseEntity<Game> getAllFieldsOfGame(@PathVariable(value = "id") Long gameId) 
			throws ResourceNotFoundException{
		Game game = GR.findById(gameId).orElseThrow(() -> 
		new ResourceNotFoundException("Game Not Found For This Id :: " + gameId));
		return ResponseEntity.ok().body(game);
	}
	
	@PostMapping("/{id}/?fields=*") // - NOT FOR POSTING
	public Game createGame(@Validated @RequestBody Game CreateGame){
		return GR.save(CreateGame);
	}
	
	@PutMapping("/{id}")
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

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteGame(@PathVariable(value = "id") Long gameId)
			throws ResourceNotFoundException {
		Game game = GR.findById(gameId)
				.orElseThrow(() -> new ResourceNotFoundException("Game Not Found For This Id :: " + gameId));

		GR.delete(game);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
//	Final getMapping method
	public ResponseEntity<String> getGamesClient(@RequestBody String body){
		String uri = "https://api.igdb.com/v4/games";
		RestTemplate rest = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Client-ID", "7hcaebxotm5way0rgml4zq7cx20mdl");
		headers.set("Authorization", "Bearer jojmrffssxdxgzw0fk32614jkarbi3");
		
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		
		String result = rest.postForObject(uri, entity, String.class);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
}
