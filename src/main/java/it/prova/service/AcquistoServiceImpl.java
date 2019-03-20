package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.model.Acquisto;
import it.prova.model.Annuncio;
import it.prova.model.Utente;
import it.prova.repository.AcquistoRepository;
import it.prova.repository.AnnuncioRepository;
import it.prova.repository.UtenteRepository;

@Service
public class AcquistoServiceImpl implements AcquistoService {
	
	@Autowired
	private AcquistoRepository acquistoRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private AnnuncioRepository annuncioRepository;

	@Transactional(readOnly=true)
	public List<Acquisto> listAllAcquisto() {
		return (List<Acquisto>) acquistoRepository.findAll();
	}

//	@Transactional(readOnly=true)
//	public Acquisto caricaSingoloAcquisto(long id) {
		// TODO Auto-generated method stub
//		return null;
//	}

//	@Transactional
//	public void aggiorna(Acquisto acquistoInstance) {
		// TODO Auto-generated method stub

//	}

//	@Transactional
//	public void inserisciNuovoAcquisto(Acquisto acquistoInstance) {
		// TODO Auto-generated method stub

//	}

//	@Transactional
//	public void rimuovi(Acquisto acquistoInstance) {
		// TODO Auto-generated method stub

//	}

//	@Transactional(readOnly=true)
//	public List<Acquisto> findByExample(Acquisto example) {
		// TODO Auto-generated method stub
//		return null;
//	}

	@Transactional
	public Acquisto eseguiAcquisto(Utente utente, Annuncio annuncio) {
		
		Acquisto acquisto = new Acquisto();
		
		acquisto.setAnno(2019);
		acquisto.setDescrizioneAcquisto(annuncio.getTestoAnnuncio());
		acquisto.setPrezzo(annuncio.getPrezzo());
		acquisto.setUtente(utente);
		
		int creditoUtente = utente.getCreditoResiduo();
		int prezzoAnnuncio = annuncio.getPrezzo();
		
		utente.setCreditoResiduo(creditoUtente - prezzoAnnuncio);
	
		utenteRepository.save(utente);
		
		annuncio.setAperto(false);
		
		annuncioRepository.save(annuncio);
		
		return acquistoRepository.save(acquisto);
	}
	
//	@Override
//	public List<Acquisto> listByIdUtente(long id) {
//		return acquistoRepository.findByIdUtente(id);
//	}
}
