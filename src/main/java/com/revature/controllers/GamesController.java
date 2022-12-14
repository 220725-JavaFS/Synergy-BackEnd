package com.revature.controllers;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Cover;
import com.revature.models.Game;

@RestController
@RequestMapping("/games")
@CrossOrigin
public class GamesController {
	private static Logger log = LoggerFactory.getLogger(GamesController.class);
	@PostMapping
	public ResponseEntity<Game[]> getGames(@RequestBody String body) {
		String uri = "https://api.igdb.com/v4/games";
		RestTemplate rest = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Client-ID", "b2wju3h59suvrb5pe7f2ipwq6e0xga");
		headers.set("Authorization", "Bearer pb60tb9jgd5albai0snyl43gumu0zp");

		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		Game[] games = rest.postForObject(uri, entity, Game[].class);
		log.info(games.toString());
		if (games == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(games);
		}
		return ResponseEntity.status(HttpStatus.OK).body(games);
	}

	@PostMapping("/{gameId}")
	public ResponseEntity<Game> getSingleGame(@RequestBody String body) {
		String uri = "https://api.igdb.com/v4/games";
		RestTemplate rest = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Client-ID", "b2wju3h59suvrb5pe7f2ipwq6e0xga");
		headers.set("Authorization", "Bearer pb60tb9jgd5albai0snyl43gumu0zp");

		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		Game[] games = rest.postForObject(uri, entity, Game[].class);
		
		if (games.length == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		Game game = games[0];
		log.info(game.toString());
		return ResponseEntity.status(HttpStatus.OK).body(game);
	}
	
	@PostMapping("/cover")
	public ResponseEntity<Cover> getGameCover(@RequestBody String body) {
		String uri = "https://api.igdb.com/v4/covers";
		RestTemplate rest = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Client-ID", "b2wju3h59suvrb5pe7f2ipwq6e0xga");
		headers.set("Authorization", "Bearer pb60tb9jgd5albai0snyl43gumu0zp");

		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		Cover[] covers = rest.postForObject(uri, entity, Cover[].class);
		log.info(covers.toString());
		if (covers.length == 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		Cover cover = covers[0];
		return ResponseEntity.status(HttpStatus.OK).body(cover);
	}
}
