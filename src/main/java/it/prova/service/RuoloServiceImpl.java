package it.prova.service;

import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.prova.model.Ruolo;
import it.prova.repository.RuoloRepository;

@Service
public class RuoloServiceImpl implements RuoloService {
	
	@Autowired
	private RuoloRepository ruoloRepository;

	@Transactional(readOnly=true)
	public List<Ruolo> listAllRuoli() {
		return (List<Ruolo>) ruoloRepository.findAll();
	}

	@Transactional(readOnly=true)
	public Ruolo caricaSingoloRuolo(long id) {
		return ruoloRepository.findOne(id);
	}

	@Transactional
	public void aggiorna(Ruolo ruoloInstance) {
		ruoloRepository.save(ruoloInstance);
	}

	@Transactional
	public void inserisciNuovo(Ruolo ruoloInstance) {
		ruoloRepository.save(ruoloInstance);
	}

	@Transactional
	public void rimuovi(Ruolo ruoloInstance) {
		ruoloRepository.delete(ruoloInstance);
	}

	@Transactional(readOnly=true)
	public List<Ruolo> findByExample(Ruolo example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserisciNuovoRuolo(Ruolo ruoloInstance) {
		// TODO Auto-generated method stub
		
	}

}


