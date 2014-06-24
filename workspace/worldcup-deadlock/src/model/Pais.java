package model;

import org.hibernate.annotations.Entity;

@Entity
public class Pais {
	
	Integer id;
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
