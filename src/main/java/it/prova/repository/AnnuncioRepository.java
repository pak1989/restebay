package it.prova.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.model.Annuncio;

public interface AnnuncioRepository extends CrudRepository<Annuncio, Long>, QueryByExampleExecutor<Annuncio> {

	
}
