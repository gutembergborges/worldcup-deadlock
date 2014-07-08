package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COPA")
public class Copa implements Serializable {

	@Id
	private Integer ano;
	
	@ManyToOne 
	@JoinColumn(name="id_pais", insertable=true, updatable=true) 
	private Pais pais;
	
	@OneToMany(mappedBy = "copa") 
	private List<Selecao> selecoes;
	
	@OneToMany(mappedBy = "copa") 
	private List<Jogo> jogos;

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

}
