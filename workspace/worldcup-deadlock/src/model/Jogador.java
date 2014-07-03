package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "JOGADOR")
public class Jogador {
	
	@Id
	@GeneratedValue
	@Column(name = "id_jogador")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_selecao")
	private Selecao selecao;
	
	@OneToMany(mappedBy = "id_substitucao")
	private List<Substituicao> substituicoes; 
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	
	private Integer numero;
	
	@OneToMany(mappedBy = "id_gol")
	private List<Gol> gols;
	
	

}
