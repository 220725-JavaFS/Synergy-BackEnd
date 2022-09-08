package com.VideoGame.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VideoGame.Models.User;
import com.VideoGame.Repositories.UserRepository;

@RestController 
/*
 * A convenience annotation that is itself annotated with 
 * @Controller and @ResponseBody.
 */
@RequestMapping("http://localhost")
/*
 * Annotation for mapping web requests onto methods in request-handling 
 * classes with flexible method signatures.
 */
public class UserController {
	@Autowired
	private UserRepository UR;
	
//	Get Users
	@GetMapping("/Users")
	/*
	 * Annotation for mapping HTTP GET requests onto specific handler methods.
	 */
	public List<User> getAllUsers(){
		return UR.findAll();
	}
}
