package it.prova.service;

import java.util.List;

import it.prova.model.Acquisto;
import it.prova.model.Annuncio;
import it.prova.model.Utente;

public interface AcquistoService {
	
	public List<Acquisto> listAllAcquisto();
//
//	public Acquisto caricaSingoloAcquisto(long id);
//
//	public void aggiorna(Acquisto acquistoInstance);
//
//	public void inserisciNuovoAcquisto(Acquisto acquistoInstance);
//
//	public void rimuovi(Acquisto acquistoInstance);
//
//	public List<Acquisto> findByExample(Acquisto example);
//	
	public Acquisto eseguiAcquisto(Utente utente, Annuncio annuncio);
//
//	public List<Acquisto> listByIdUtente(long id);
}
