package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Ses;
import com.revature.models.Users;
import com.revature.services.SesService;

@RestController
@RequestMapping("/ses")
@CrossOrigin
public class SesController {

	private SesService sesService;
	private static Logger log = LoggerFactory.getLogger(SesController.class);
	
	@Autowired
		public SesController(SesService sesService) {
			super();
			this.sesService = sesService;
		}

		@GetMapping
		public ResponseEntity<Users> getSession(HttpServletRequest request) {
			Ses session = sesService.getSession(request.getRemoteAddr());
			Users user = null;
			log.info(user.toString());
			if(session!=null) {
				user = session.getUser();
				return ResponseEntity.status(HttpStatus.OK).body(user);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}



}
