package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Users;

public interface UsersDAO extends JpaRepository<Users, Integer>{

	Users findByUsernameAndPassword(String username, String password);

	Users findByUsername(String username);

}
