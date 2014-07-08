package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "SUBSTITUICAO")
public class Substituicao implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id_substituicao")
	private Long id;
	
	@Temporal(TemporalType.TIME)
	private Date tempo; //Na dúvida se o tipo é Date do java.util mesmo
	
	@ManyToOne
	@JoinColumn(name="id_jogo", insertable=true, updatable=true)
	private Jogo jogo;
	
	@ManyToOne
	@JoinColumn(name="id_selecao", insertable=true, updatable=true)
	private Selecao selecao;
	
	@OneToOne
	@JoinColumn(name = "id_jogador", insertable=false, updatable=false)
	private Jogador jogadorSai;
	
	@OneToOne
	@JoinColumn(name = "id_jogador", insertable=true, updatable=true)
	private Jogador jogadorEntra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTempo() {
		return tempo;
	}

	public void setTempo(Date tempo) {
		this.tempo = tempo;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	public Jogador getJogadorSai() {
		return jogadorSai;
	}

	public void setJogadorSai(Jogador jogadorSai) {
		this.jogadorSai = jogadorSai;
	}

	public Jogador getJogadorEntra() {
		return jogadorEntra;
	}

	public void setJogadorEntra(Jogador jogadorEntra) {
		this.jogadorEntra = jogadorEntra;
	}
	
	

}
