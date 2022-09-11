package com.VideoGame.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// ^^^ took away repository to use method inside of custom service class

import com.VideoGame.Models.Game;


public interface GameRepository extends JpaRepository<Game, Long> {
	Optional<List <Game>> findByGameId(int gameId);
}
