package com.lucaspinheiro.diogameawards.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lucaspinheiro.diogameawards.domain.model.Game;
import com.lucaspinheiro.diogameawards.domain.model.GameRepository;
import com.lucaspinheiro.diogameawards.service.GameService;
import com.lucaspinheiro.diogameawards.service.exeption.BusinessExeption;
import com.lucaspinheiro.diogameawards.service.exeption.NoContentExeption;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository repository;
	
	@Override
	public List<Game> findAll() {
		List <Game> games = repository.findAll(Sort.by(Direction.DESC, "votes"));
		return games;
	}

	@Override
	public Game findByid(Long id) {
		Optional <Game> games = repository.findById(id);
		return  games.orElseThrow(() -> new NoContentExeption() );
	}

	@Override
	public void insert(Game game) {
		repository.save(game);	
	}

	@Override
	public void update(Long id, Game game) {
		Game gameDb = findByid(id);
		if(gameDb.getId().equals(game.getId())){
			repository.save(game);
		}else {
			throw new BusinessExeption("Os IDs para alteração são divergentes.");
		}
	}

	@Override
	public void delete(Long id) {
		Game gameDb = findByid(id);
		repository.delete(gameDb);
	}

	@Override
	public void vote(Long id) {
		Game gameDb = findByid(id);
		gameDb.setVotes(gameDb.getVotes() + 1);
		update(id, gameDb);
	}

}
