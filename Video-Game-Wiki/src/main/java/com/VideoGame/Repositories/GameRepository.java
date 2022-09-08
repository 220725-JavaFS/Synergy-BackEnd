package com.VideoGame.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VideoGame.Models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
