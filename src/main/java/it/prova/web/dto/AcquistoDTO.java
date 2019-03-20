package it.prova.web.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.prova.model.Acquisto;
import it.prova.model.Utente;

public class AcquistoDTO {

	private long id;
	private String descrizioneAcquisto;
	private int prezzo;
	private int anno;
	@JsonIgnoreProperties(value = { "acquisti", "annunci", "ruoli", "password", "admin" })
	private Utente utente;

	public AcquistoDTO() {
	}

	public AcquistoDTO(Acquisto source) {
		super();
		this.id = source.getId();
		this.descrizioneAcquisto = source.getDescrizioneAcquisto();
		this.prezzo = source.getPrezzo();
		this.anno = source.getAnno();
		this.utente = source.getUtente();
	}
	
	public static Set<AcquistoDTO> listAcquistoDTO(List<Acquisto> listaAcquisti) {
		Set<AcquistoDTO> setAcquistiDTO = new HashSet<>();
		listaAcquisti.forEach(acquisto -> setAcquistiDTO.add(new AcquistoDTO(acquisto)));
		return setAcquistiDTO;
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
