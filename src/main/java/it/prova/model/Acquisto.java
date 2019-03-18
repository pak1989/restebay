package it.prova.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Acquisto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String descrizioneAcquisto;
	private int prezzo;
	private int anno;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utente_id", nullable = false)
	private Utente utente;

	public Acquisto() {
	}

	public Acquisto(String descrizioneAcquisto, int prezzo, int anno, Utente utente) {
		super();
		this.descrizioneAcquisto = descrizioneAcquisto;
		this.prezzo = prezzo;
		this.anno = anno;
		this.utente = utente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizioneAcquisto() {
		return descrizioneAcquisto;
	}

	public void setDescrizioneAcquisto(String descrizioneAcquisto) {
		this.descrizioneAcquisto = descrizioneAcquisto;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
