package com.lucaspinheiro.diogameawards.service;

import java.util.List;

import com.lucaspinheiro.diogameawards.domain.model.Game;

public interface GameService {
	
	List<Game> findAll();
	
	Game findByid(Long id);
	
	void insert (Game game);
	
	void update (Long id, Game game);
	
	void delete (Long id);

	void vote(Long id);
}
