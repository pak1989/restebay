package it.prova.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>, QueryByExampleExecutor<Category> {

	
}
