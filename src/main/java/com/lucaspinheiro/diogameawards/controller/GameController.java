package com.lucaspinheiro.diogameawards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucaspinheiro.diogameawards.domain.model.Game;
import com.lucaspinheiro.diogameawards.service.GameService;

@RestController
@CrossOrigin(origins = "*")
public class GameController extends BaseRestController {

	@Autowired
	private GameService businessLayer;
	
	//pega os itens do banco
	@GetMapping("games")
	public ResponseEntity<List<Game>> findAll() {
		List<Game> games = businessLayer.findAll();
		return ResponseEntity.ok(games);
	}
	
	@GetMapping("games/{id}")
	public ResponseEntity <Game> findAll1(@PathVariable Long id) {
		Game game = businessLayer.findByid(id); 
		return ResponseEntity.ok(game);
	}
	
	@PostMapping("games")
	public ResponseEntity <Game> insert(@RequestBody Game game) {
		businessLayer.insert(game);	  
		return ResponseEntity.ok(game);
		//tentar fazer em vez do ok um creat
	}
	
	@PutMapping("games/{id}")
	public ResponseEntity <Game> update (@PathVariable Long id, @RequestBody Game game) {
		businessLayer.update(id, game);	  
		return ResponseEntity.ok(game);
	}
	
	@DeleteMapping("games/{id}")
	public ResponseEntity <Game> delete(@PathVariable Long id) {
		businessLayer.delete(id);	  
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping("games/{id}/vote")
	public ResponseEntity <Game> update (@PathVariable Long id) {
		businessLayer.vote(id);	  
		return ResponseEntity.ok().build();
	}
}
