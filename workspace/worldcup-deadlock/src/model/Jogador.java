package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "JOGADOR")
public class Jogador implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "id_jogador")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_selecao", insertable=true, updatable=true)
	private Selecao selecao;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar calendar;
	
	private Integer numero;
	
	@OneToMany(mappedBy = "jogador")
	private List<Gol> gols;
	
	@ManyToMany
	@JoinTable(name="escalacao_jogador", joinColumns=@JoinColumn(name="id_jogador"), inverseJoinColumns=@JoinColumn(name="id_escalacao"))
	private List<Escalacao> escalacoes;
	
	@Enumerated (EnumType.STRING)
	@Column (name="POSICAO")
	private Posicao posicao;
	

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getData_nascimento() {
		return calendar;
	}

	public void setData_nascimento(Calendar calendar) {
		this.calendar = calendar;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Gol> getGols() {
		return gols;
	}

	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}

	public List<Escalacao> getEscalacoes() {
		return escalacoes;
	}

	public void setEscalacoes(List<Escalacao> escalacoes) {
		this.escalacoes = escalacoes;
	}

}
