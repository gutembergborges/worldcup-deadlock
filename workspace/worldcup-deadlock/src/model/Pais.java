package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@Id @GeneratedValue
	Long id;
	String nome;
	String continente;
	
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

} 
