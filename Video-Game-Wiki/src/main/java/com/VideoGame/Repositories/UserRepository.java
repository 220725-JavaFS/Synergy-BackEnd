package com.VideoGame.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VideoGame.Models.User;

@Repository //Makes a spring component
public interface UserRepository extends JpaRepository<User, Long>{

}
