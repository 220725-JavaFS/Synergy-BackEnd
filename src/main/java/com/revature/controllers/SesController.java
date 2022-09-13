package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Session;
import com.revature.models.Users;
import com.revature.services.SessionService;

@RestController
@RequestMapping("/ses")
@CrossOrigin
public class SesController {

	private SessionService sessionService;

	@Autowired
		public SesController(SessionService sessionService) {
			super();
			this.sessionService = sessionService;
		}

		@GetMapping
		public ResponseEntity<Users> getSession(HttpServletRequest request) {
			Session session = sessionService.getSession(request.getRemoteAddr());
			Users user = null;
			if(session!=null) {
				user = session.getUser();
				return ResponseEntity.status(HttpStatus.OK).body(user);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	@PostMapping
	public ResponseEntity<Users> storeActive(@RequestBody Users body, HttpServletRequest request) {
		System.out.println(body.toString());
		sessionService.makeSes(request.getRemoteAddr(), body);
		return ResponseEntity.status(HttpStatus.OK).body(body);
	}

}
