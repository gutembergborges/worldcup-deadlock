package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "SUBSTITUICAO")
public class Substituicao {
	
	@Id
	@GeneratedValue
	@Column(name = "id_substituicao")
	private Long id;
	
	@Temporal(TemporalType.TIME)
	private Date tempo; //Na dúvida se o tipo é Date do java.util mesmo
	
	@ManyToOne
	@JoinColumn (name = "id_jogo")
	private Jogo jogo;
	
	@ManyToOne
	@JoinColumn (name = "id_selecao")
	private Selecao selecao;
	
	@ManyToOne
	@JoinColumn(name = "id_jogador")
	private Jogador jogadorSai;
	
	@ManyToOne
	@JoinColumn(name = "id_jogador")
	private Jogador jogadorEntra;

}
