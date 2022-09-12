package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Users;
import com.revature.repositories.UsersDAO;

@Service
public class UserService {
	
	private UsersDAO uDao;
	
	@Autowired
	public UserService(UsersDAO uDao) {
		super();
		this.uDao = uDao;
	}
	
	public List<Users> findAllUsers() {
		return uDao.findAll();
	}
	
	public Users addUser(Users u) {
		return uDao.save(u);
	}
	
	public Users findUserByUsernameAndPassword(String username, String password) {
		return uDao.findByUsernameAndPassword(username, password);
	}
	
	public Users findUserByUsername(String username) {
		return uDao.findByUsername(username);
	}
	
}
