package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table (name = "JOGO")
public class Jogo implements Serializable {
	
	@Id
	@GeneratedValue
	@Column(name = "id_jogo")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_copa", insertable=true, updatable=true)
	private Copa copa;
	
	@ManyToOne
	@JoinColumn(name = "id_selecao", insertable=false, updatable=false)
	private Selecao selecaoA;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "id_escalacao")
	private Escalacao escalacaoA;
	
	@ManyToOne
	@JoinColumn(name="id_selecao", insertable=true, updatable=true)
	private Selecao selecaoB;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "id_escalacao")
	private Escalacao escalacaoB;
	
	@OneToMany(mappedBy = "jogo")
	private List<Gol> gols;
		
	@Temporal(TemporalType.TIME)
	private Date data; //Na dúvida se o tipo é Date do java.util mesmo
	
	private String local;
	
	@Enumerated (EnumType.STRING)
	@Column (name="FASE")
	private Fase fase;
	
	@OneToMany(mappedBy = "jogo")
	private List<Substituicao> substituicoes;
	
	public List<Substituicao> getSubstituicoes(){
		return substituicoes;
	}
	
	public void setSubstituicoes(List<Substituicao> substituicoes){
		this.substituicoes = substituicoes;
	}
	
	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Copa getCopa() {
		return copa;
	}

	public void setCopa(Copa copa) {
		this.copa = copa;
	}

	public Selecao getSelecaoA() {
		return selecaoA;
	}

	public void setSelecaoA(Selecao selecaoA) {
		this.selecaoA = selecaoA;
	}

	public Escalacao getEscalacaoA() {
		return escalacaoA;
	}

	public void setEscalacaoA(Escalacao escalacaoA) {
		this.escalacaoA = escalacaoA;
	}

	public Selecao getSelecaoB() {
		return selecaoB;
	}

	public void setSelecaoB(Selecao selecaoB) {
		this.selecaoB = selecaoB;
	}

	public Escalacao getEscalacaoB() {
		return escalacaoB;
	}

	public void setEscalacaoB(Escalacao escalacaoB) {
		this.escalacaoB = escalacaoB;
	}

	public List<Gol> getGols() {
		return gols;
	}

	public void setGols(List<Gol> gols) {
		this.gols = gols;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
}
