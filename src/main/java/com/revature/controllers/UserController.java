package com.revature.controllers;

import java.util.List;

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

import com.revature.models.Users;
import com.revature.services.SesService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {
	
	private UserService us;
	private SesService ss;
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	public UserController(UserService us, SesService ss) {
		super();
		this.us = us;
		this.ss = ss;
	}
	
	//for viewing info persistence from front to back end
	@GetMapping("register")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = us.findAllUsers();
		log.info(users.toString());
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	//registers new user
	@PostMapping("register")
	public  ResponseEntity<Users> registerUser(@RequestBody Users u) throws Exception{
		String usernameInput = u.getUsername();
		if(usernameInput != null && !usernameInput.isEmpty()) {
			Users user = us.findUserByUsername(usernameInput);
			log.info(user.toString());
			if(user != null) {
				throw new Exception("Error: The user with the username " + usernameInput + " already exists. Please choose a different username.");
			}
		}
		Users user = null;
		user = us.addUser(u);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	//logs in user with username and password
	@PostMapping("login")
	public ResponseEntity<Users> loginUser(@RequestBody Users u, HttpServletRequest request) throws Exception {
		String usernameInput = u.getUsername();
		String passwordInput = u.getPassword();
		Users user = null;
		if(usernameInput != null && passwordInput != null) {
			user = us.findUserByUsernameAndPassword(usernameInput, passwordInput);
		}if(user == null) {
			throw new Exception("Error: The username or password is incorrect.");
		}
		log.info(user.toString());
		ss.makeSes(request.getRemoteAddr(), user);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	

}
