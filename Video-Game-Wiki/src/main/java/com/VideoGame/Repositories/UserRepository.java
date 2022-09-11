package com.VideoGame.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VideoGame.Models.User;

@Repository //Makes a spring component
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findUserById(int userId);
	/*	Optional Method
	 * A container object which may or may not contain a non-null value. 
	 * If a value is present, isPresent() will return true and get() will 
	 * return the value.
	 */
}
