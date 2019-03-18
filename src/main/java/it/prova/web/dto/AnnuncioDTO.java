package it.prova.web.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.prova.model.Annuncio;
import it.prova.model.Category;
import it.prova.model.Utente;

public class AnnuncioDTO {

	private long id;
	private Boolean aperto;
	private String testoAnnuncio;
	private int prezzo;
	private Set<Category> category = new HashSet<>(0);
	@JsonIgnoreProperties(value = { "acquisti", "annunci", "ruoli", "password", "admin" })
	private Utente utente;

	public AnnuncioDTO() {
	}

	public AnnuncioDTO(Annuncio source) {
		this.id = source.getId();
		this.aperto = source.getAperto();
		this.testoAnnuncio = source.getTestoAnnuncio();
		this.prezzo = source.getPrezzo();
		for (Category categoryItem : source.getCategory()) {
			this.category.add(new CategoryDTO(categoryItem));
		}
		this.utente = source.getUtente();
	}

	public AnnuncioDTO(Boolean aperto, String testoAnnuncio, int prezzo) {
		super();
		this.aperto = aperto;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
	}

	public AnnuncioDTO(long id, Boolean aperto, String testoAnnuncio, int prezzo, Utente utente) {
		super();
		this.id = id;
		this.aperto = aperto;
		this.testoAnnuncio = testoAnnuncio;
		this.prezzo = prezzo;
		this.utente = utente;
	}

	public static Set<AnnuncioDTO> listAnnuncioDTO(List<Annuncio> listaAnnunci) {
		Set<AnnuncioDTO> setAnnunciDTO = new HashSet<>();
		listaAnnunci.forEach(annuncio -> setAnnunciDTO.add(new AnnuncioDTO(annuncio)));
		return setAnnunciDTO;
	}

	public static AnnuncioDTO buildAnnuncioDTO(Annuncio annuncioInput) {
		return new AnnuncioDTO(annuncioInput.getId(), annuncioInput.getAperto(), annuncioInput.getTestoAnnuncio(),
				annuncioInput.getPrezzo(), annuncioInput.getUtente());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getAperto() {
		return aperto;
	}

	public void setAperto(Boolean aperto) {
		this.aperto = aperto;
	}

	public String getTestoAnnuncio() {
		return testoAnnuncio;
	}

	public void setTestoAnnuncio(String testoAnnuncio) {
		this.testoAnnuncio = testoAnnuncio;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public HashMap<String, String> validate() {

		HashMap<String, String> messagesList = new HashMap<>();

		if (StringUtils.isEmpty(testoAnnuncio)) {
			messagesList.put("Nome", "Campo obbligatorio!");
		}

		if (StringUtils.isEmpty(prezzo + "")) {
			messagesList.put("Cognome", "Campo obbligatorio!");
		}

//		if (StringUtils.isEmpty(username)) {
//			messagesList.put("Username", "Campo obbligatorio!");
//		}

		return messagesList;
	}
}
