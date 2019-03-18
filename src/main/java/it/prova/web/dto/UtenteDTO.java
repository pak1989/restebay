package it.prova.web.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.prova.model.Acquisto;
import it.prova.model.Annuncio;
import it.prova.model.Ruolo;
import it.prova.model.Utente;

public class UtenteDTO {

	private long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dataRegistrazione;
	private int creditoResiduo;
	@JsonIgnoreProperties(value = { "id", "codice" })
	private Set<RuoloDTO> ruoli = new HashSet<>();
	@JsonIgnoreProperties(value = { "utente", "category" })
	private Set<AnnuncioDTO> annunci = new HashSet<>();	
	@JsonIgnoreProperties(value = { "utente" })
	private Set<AcquistoDTO> acquisti = new HashSet<>();

	public UtenteDTO() {

	}

	public UtenteDTO(Utente source) {
		System.out.println(source.toString());
		this.id = source.getId();
		this.nome = source.getNome();
		this.cognome = source.getCognome();
		this.username = source.getUsername();
		this.password = source.getPassword();
		this.dataRegistrazione = source.getDataRegistrazione();
		this.creditoResiduo = source.getCreditoResiduo();
		for (Ruolo ruoloItem : source.getRuoli()) {
			this.ruoli.add(new RuoloDTO(ruoloItem));
		}
		for (Annuncio annuncioItem : source.getAnnunci()) {
			this.annunci.add(new AnnuncioDTO(annuncioItem));
		}
		for (Acquisto acquistoItem : source.getAcquisti()) {
			this.acquisti.add(new AcquistoDTO(acquistoItem));
		}
	}

	public UtenteDTO(String nome, String cognome, String username, String password, Date dataRegistrazione,
			int creditoResiduo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
		this.creditoResiduo = creditoResiduo;
	}

	public UtenteDTO(long id, String nome, String cognome, String username, String password, Date dataRegistrazione,
			int creditoResiduo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
		this.creditoResiduo = creditoResiduo;
	}

	public static Set<UtenteDTO> listUtenteDTO(List<Utente> listaUtenti) {
		Set<UtenteDTO> setUtentiDTO = new HashSet<>();
		listaUtenti.forEach(utente -> setUtentiDTO.add(new UtenteDTO(utente)));
		return setUtentiDTO;
	}

	public static UtenteDTO buildUtenteDTO(Utente utenteInput) {
		return new UtenteDTO(utenteInput.getId(), utenteInput.getNome(), utenteInput.getCognome(),
				utenteInput.getUsername(), utenteInput.getPassword(), utenteInput.getDataRegistrazione(),
				utenteInput.getCreditoResiduo());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public int getCreditoResiduo() {
		return creditoResiduo;
	}

	public void setCreditoResiduo(int creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}

	public Set<RuoloDTO> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<RuoloDTO> ruoli) {
		this.ruoli = ruoli;
	}

	public Set<AnnuncioDTO> getAnnunci() {
		return annunci;
	}

	public void setAnnunci(Set<AnnuncioDTO> annunci) {
		this.annunci = annunci;
	}

	public Set<AcquistoDTO> getAcquisti() {
		return acquisti;
	}

	public void setAcquisti(Set<AcquistoDTO> acquisti) {
		this.acquisti = acquisti;
	}

	public HashMap<String, String> validate() {

		HashMap<String, String> messagesList = new HashMap<>();

		if (StringUtils.isEmpty(nome)) {
			messagesList.put("Nome", "Campo obbligatorio!");
		}

		if (StringUtils.isEmpty(cognome)) {
			messagesList.put("Cognome", "Campo obbligatorio!");
		}

		if (StringUtils.isEmpty(username)) {
			messagesList.put("Username", "Campo obbligatorio!");
		}

		return messagesList;
	}

	@Override
	public String toString() {
		return "UtenteDTO [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username
				+ ", password=" + password + ", dataRegistrazione=" + dataRegistrazione + ", creditoResiduo="
				+ creditoResiduo + ", ruoli=" + ruoli + ", annunci=" + annunci + ", acquisti=" + acquisti + "]";
	}
	
	
}
