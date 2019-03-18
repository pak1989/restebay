package it.prova.service;

import java.util.List;

import it.prova.model.Category;

public interface CategoryService {
	
	public List<Category> listAllCategory();

	public Category caricaSingoloCategory(long id);

	public void aggiorna(Category categoryInstance);

	public void inserisciNuovoCategory(Category categoryInstance);

	public void rimuovi(Category categoryInstance);

	public List<Category> findByExample(Category example);

}
