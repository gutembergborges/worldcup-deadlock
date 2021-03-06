package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "PAIS")
public class Pais implements Serializable {

	@Id 
	@GeneratedValue
	@Column(name = "id_pais")
	private Long id;
	
	private String nome;
	private String continente;
	
	@OneToMany(mappedBy = "pais")
	private List<Copa> copas;
	
	@OneToMany(mappedBy = "pais")
	private List<Selecao> selecoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public List<Copa> getCopas() {
		return copas;
	}

	public void setCopas(List<Copa> copas) {
		this.copas = copas;
	}

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

} 
