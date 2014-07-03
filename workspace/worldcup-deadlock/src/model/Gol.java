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
@Table(name = "GOL")
public class Gol {
	
	@Id
	@GeneratedValue
	@Column(name = "id_gol")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_jogador")
	private Jogador jogador;
	
	@ManyToOne
	@JoinColumn(name = "id_jogo")
	private Jogo jogo;
	
	@Temporal(TemporalType.TIME)
	private Date tempo; //Na dúvida se o tipo é Date do java.util mesmo
	
	private Boolean foiContra;

}
