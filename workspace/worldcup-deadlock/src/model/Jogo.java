package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table (name = "JOGO")
public class Jogo {
	
	@Id
	@GeneratedValue
	@Column(name = "id_jogo")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ano")
	private Copa copa;
	
	@ManyToOne
	@JoinColumn(name = "id_selecao")
	private Selecao selecaoA;
	
	@ManyToOne
	@JoinColumn(name = "id_selecao")
	private Selecao selecaoB;
	
	@OneToMany(mappedBy = "GOL")
	private List<Gol> gols;
	
	private String data;
	private String local;

	
	
}
