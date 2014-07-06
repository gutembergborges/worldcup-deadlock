package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "ESCALACAO")
public class Escalacao implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id_escalacao")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_selecao")
	private Selecao selecao;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "id_jogo")
	private Jogo jogo;
	
	@OneToMany
	@JoinColumn(name = "id_jogador")
	private List<Jogador> jogadores;

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

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}
