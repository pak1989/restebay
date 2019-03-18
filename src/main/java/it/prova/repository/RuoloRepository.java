package it.prova.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.model.Ruolo;

public interface RuoloRepository extends CrudRepository<Ruolo, Long>, QueryByExampleExecutor<Ruolo> {

	
}
