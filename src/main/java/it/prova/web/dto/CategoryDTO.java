package it.prova.web.dto;

import it.prova.model.Category;

public class CategoryDTO extends Category {

	private long id;
	private String descrizione;
	private String nome;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Category source) {
		super();
		this.id = source.getId();
		this.descrizione = source.getDescrizione();
		this.nome = source.getNome();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
