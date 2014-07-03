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
@Table (name = "COPA")
public class Copa implements Serializable {
	
	@Id
	private Integer ano;
	
	@ManyToOne 
	@JoinColumn(name = "id_pais")
	private Pais pais;
	
	@OneToMany (mappedBy = "SELECAO")
	private List<Selecao> selecoes;
	
	@OneToMany (mappedBy = "JOGO")
	private List<Jogo> jogos;

}
