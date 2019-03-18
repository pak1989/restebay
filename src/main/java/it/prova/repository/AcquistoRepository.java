package it.prova.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.model.Acquisto;

public interface AcquistoRepository extends CrudRepository<Acquisto, Long>, QueryByExampleExecutor<Acquisto> {
}
