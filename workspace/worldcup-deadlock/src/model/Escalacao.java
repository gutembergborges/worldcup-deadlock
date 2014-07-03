package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Escalacao {
	
	@Id
	@GeneratedValue
	@Column(name = "id_escalacao")
	private Long id;
	
	@ManyToMany
	@JoinColumn(name = "id_jogador")
	private List<Jogador> jogadores;
	

}
