package model;

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
public class Selecao {

	@Id
	@GeneratedValue
	@Column(name = "id_selecao")
	private Long id;
	
	private Integer ano;
	
	@ManyToOne 
	@JoinColumn(name = "id_pais")
	private Pais pais;
	
	@OneToMany 
	(mappedBy = "COPA")
	@JoinColumn(name = "ano") 
	private Copa copa;
	
	@OneToOne
	@JoinColumn(name = "id_tecnico")
	private Tecnico tecnico;
	
	@OneToMany (mappedBy = "id_jogo")
	private List<Jogo> jogos;
	
	@OneToMany (mappedBy = "id_jogador")
	private List<Jogador> jogadores;
	
	private Integer grupo;
	private Integer posicao;
	
}
