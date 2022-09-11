package com.VideoGame.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VideoGame.Models.User;
import com.VideoGame.Repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository UR;
	
	@Autowired
	public UserService(UserRepository UR) {
		super();
		this.UR = UR;
	}
	
	public List<User> findAllUsers() {
		return UR.findAll();
	}
	
	public void addUser(User u) {
		UR.save(u);
	}

}