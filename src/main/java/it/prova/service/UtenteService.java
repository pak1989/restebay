package it.prova.service;

import java.util.List;

import it.prova.model.Utente;

public interface UtenteService {
	
	public List<Utente> listAllUtenti() ;

	public Utente caricaSingoloUtente(long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisciNuovo(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);

	public Utente eseguiAccesso(String username, String password);
	
//	public List<Utente> findByAttributes(Utente example);
}
