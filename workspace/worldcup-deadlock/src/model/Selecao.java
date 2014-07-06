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
import javax.persistence.Table;

@Entity 
@Table(name = "SELECAO")
public class Selecao implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id_selecao")
	private Long id;
	
	private Integer ano;
	
	@ManyToOne 
	@JoinColumn(name = "id_pais")
	private Pais pais;
	
	@OneToMany(mappedBy = "COPA")
	@JoinColumn(name = "ano") 
	private Copa copa;
	
	@OneToOne
	@JoinColumn(name = "id_tecnico")
	private Tecnico tecnico;
	
	@OneToMany (mappedBy = "id_jogo")
	private List<Jogo> jogos;
	
	@OneToMany (mappedBy = "id_jogador")
	private List<Jogador> jogadores;
	
	@OneToMany (mappedBy = "id_escalacao")
	private List<Escalacao> escalacoes;
	
	@OneToMany (mappedBy = "id_gol")
	private List<Gol> gols;
	
	private Integer grupo;
	private Integer posicao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Copa getCopa() {
		return copa;
	}
	public void setCopa(Copa copa) {
		this.copa = copa;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public List<Escalacao> getEscalacoes() {
		return escalacoes;
	}
	public void setEscalacoes(List<Escalacao> escalacoes) {
		this.escalacoes = escalacoes;
	}
	public List<Gol> getGols() {
		return gols;
	}
	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}
	public Integer getGrupo() {
		return grupo;
	}
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}
	public Integer getPosicao() {
		return posicao;
	}
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	
}
