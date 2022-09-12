package com.revature.controllers;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Rating;

@RestController
@RequestMapping("/games")
@CrossOrigin
public class Games {

	@GetMapping
	public ResponseEntity<String> getHelloClient(@RequestBody String body){
		String uri = "https://api.igdb.com/v4/games";
		RestTemplate rest = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Client-ID", "b2wju3h59suvrb5pe7f2ipwq6e0xga");
		headers.set("Authorization", "Bearer pb60tb9jgd5albai0snyl43gumu0zp");
		
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		
		String result = rest.postForObject(uri, entity, String.class);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
