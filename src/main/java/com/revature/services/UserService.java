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
	
	public void addUser(Users u) {
		uDao.save(u);
	}

}
