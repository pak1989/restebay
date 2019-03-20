package it.prova.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.model.Utente;
import it.prova.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
//	@Autowired
//	private RuoloRepository ruoloRepository;
//	
//	@Autowired
//	private AcquistoRepository acquistoRepository;
//	
//	@Autowired
//	private AnnuncioRepository annuncioRepository;
	

	@Transactional(readOnly=true)
	public List<Utente> listAllUtenti() {
		// TODO Auto-generated method stub
		return (List<Utente>) utenteRepository.findAll();
	}

	@Transactional(readOnly=true)
	public Utente caricaSingoloUtente(long id) {
		return utenteRepository.findOne(id);
	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		utenteRepository.save(utenteInstance);

	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		utenteRepository.save(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		utenteRepository.delete(utenteInstance);
	}

	@Transactional(readOnly=true)
	public List<Utente> findByExample(Utente example) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Transactional(readOnly=true)
//	public Utente eseguiAccesso(String username, String password) {
//		return utenteRepository.executeLogin(username, password);
//	}
//	
	@Override
	@Transactional(readOnly=true)
	public Utente eseguiAccesso(String username, String password) {
		Query query = entityManager
				.createQuery("SELECT u FROM Utente u WHERE u.username = :usernameParam and u.password= :passwordParam");
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", password);

		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}

//	@Override
//	public List<Utente> findByAttributes(Utente example) {
//		return utenteRepository.findByAllByAttribute(example);
//	}
}
