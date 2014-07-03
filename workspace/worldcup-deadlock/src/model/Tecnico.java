package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tecnico {
	
	@Id
	@GeneratedValue
	@Column(name = "id_tecnico")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_selecao")
	private Selecao selecao;
	
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date data_nascimento;
	
	
}
