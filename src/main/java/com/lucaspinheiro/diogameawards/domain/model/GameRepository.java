package com.lucaspinheiro.diogameawards.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/* Faz as operações no banco de dados*/

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	
}
