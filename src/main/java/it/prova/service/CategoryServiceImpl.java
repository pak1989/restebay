package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.model.Category;
import it.prova.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {
	
//	@Autowired
//	private AnnuncioRepository annuncioRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional(readOnly=true)
	public List<Category> listAllCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

	@Transactional(readOnly=true)
	public Category caricaSingoloCategory(long id) {
		return categoryRepository.findOne(id);
	}

	@Transactional
	public void aggiorna(Category categoryInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void inserisciNuovoCategory(Category categoryInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void rimuovi(Category categoryInstance) {
		// TODO Auto-generated method stub

	}

	@Transactional(readOnly=true)
	public List<Category> findByExample(Category example) {
		// TODO Auto-generated method stub
		return null;
	}

}
