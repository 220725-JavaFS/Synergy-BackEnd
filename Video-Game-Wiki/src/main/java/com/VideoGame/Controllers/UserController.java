package com.VideoGame.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VideoGame.Models.User;
import com.VideoGame.Repositories.UserRepository;
import com.VideoGame.Services.UserService;

@RestController 
/*
 * A convenience annotation that is itself annotated with 
 * @Controller and @ResponseBody.
 */
@RequestMapping("/users")
/*
 * Annotation for mapping web requests onto methods in request-handling 
 * classes with flexible method signatures.
 */
public class UserController {
	@Autowired
	private UserRepository UR;
	private UserService US;
	
//	Get Users
	/*
	 * Annotation for mapping HTTP GET requests onto specific handler methods.
	 */
	@GetMapping
	public List<User> getAllUsersREPO(){
		return UR.findAll();
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> user = US.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping
	public ResponseEntity<List<User>> newUser(@RequestBody User U){
		US.addUser(U);
		return ResponseEntity.status(HttpStatus.CREATED).body(US.findAllUsers());
	}
}
