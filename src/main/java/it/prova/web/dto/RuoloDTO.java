package it.prova.web.dto;

import it.prova.model.Ruolo;

public class RuoloDTO {

	private long id;
	private String descrizione;
	private String codice;

	public RuoloDTO() {

	}
	
	public RuoloDTO(Ruolo source) {
		this.id = source.getId();
		this.descrizione = source.getDescrizione();
		this.codice = source.getCodice();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
