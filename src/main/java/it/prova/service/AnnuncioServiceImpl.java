package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.model.Annuncio;
import it.prova.repository.AnnuncioRepository;

@Service
public class AnnuncioServiceImpl implements AnnuncioService {

	@Autowired
	private AnnuncioRepository annuncioRepository;

//	@Autowired
//	private UtenteRepository utenteRepository;

	@Transactional(readOnly = true)
	public List<Annuncio> listAllAnnuncio() {
		return (List<Annuncio>) annuncioRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Annuncio caricaSingoloAnnuncio(long id) {
		return annuncioRepository.findOne(id);
	}

	// public Annuncio caricaSingoloAnnuncioEager(long id) {
	// return annuncioRepository.getEager(id);
	// }

	@Transactional
	public void aggiorna(Annuncio annuncioInstance) {
		annuncioRepository.save(annuncioInstance);
	}

	@Transactional
	public void inserisciNuovoAnnuncio(Annuncio annuncioInstance) {
		annuncioRepository.save(annuncioInstance);
	}

	@Transactional
	public void rimuovi(Annuncio annuncioInstance) {
		annuncioRepository.delete(annuncioInstance);
	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByExample(Annuncio example) {
		 ExampleMatcher matcher = ExampleMatcher.matching()     
                 .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                 //.withIgnoreCase();   
		return (List<Annuncio>) annuncioRepository.findAll(Example.of(example,matcher));
	}
	
	@Transactional(readOnly = true)
	public List<Annuncio> findByTestoAnnuncio(String testoAnnuncio){
		return annuncioRepository.findByTestoAnnuncio(testoAnnuncio);
	}

	@Override
	public List<Annuncio> listByIdUtente(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Transactional(readOnly = true)
	// public List<Annuncio> findByExample2(Annuncio annuncioInstance) {
	// return annuncioRepository.findByExample2(annuncioInstance);
	// }
	//
	// @Transactional(readOnly = true)
	// public List<Annuncio> listByIdUtente(long id) {
	// return annuncioRepository.listByIdUtente(id);
	// }

}
