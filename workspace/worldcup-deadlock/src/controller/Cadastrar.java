package controller;

import java.util.Date;
import java.util.List;

import model.*;

public class Cadastrar {
	
	private PaisDAOHibernate paisDAO = null;
	private JogadorDAOHibernate jogadorDAO = null;
	private TecnicoDAOHibernate tecnicoDAO = null;
	private SelecaoDAOHibernate selecaoDAO = null;
	private CopaDAOHibernate copaDAO = null;
	private EscalacaoDAOHibernate escalacaoDAO = null;
	private JogoDAOHibernate jogoDAO = null;
	private GolDAOHibernate golDAO = null;
	
	//UserStory#01
	public void cadastrarPais(String nome, String continente){
		
		Pais pais = new Pais();
		pais.setNome(nome);
		pais.setContinente(continente);
		
		paisDAO = new PaisDAOHibernate();
		paisDAO.adicionar(pais);
		
	}
	
	//UserStory#02
	public void cadastrarJogador(){
		
	}
	
	//UserStory#03
	public void cadastrarTecnico(){
		
	}
	
	//UserStory#04
	public void cadastrarSelecao(Pais pais, Copa copa, List<Jogador> jogadores){
		
		Selecao selecao = new Selecao();
		selecao.setAno(copa.getAno());
		selecao.setPais(pais);
		selecao.setCopa(copa);
		selecao.setJogadores(jogadores);
		
		selecaoDAO = new SelecaoDAOHibernate();
		selecaoDAO.adicionar(selecao);
		
	}
	
	//UserStory#05
	public void cadastrarCopa(){
		
	}
	
	//UserStory#06
	public void cadastrarEscalacao(){
		
	}
	
	//UserStory#07
	public void cadastrarJogo(Copa copa, Selecao selecaoA, Selecao selecaoB, Escalacao escalacaoA, Escalacao escalacaoB, String local, Date data){
		
		Jogo jogo = new Jogo();
		jogo.setCopa(copa);
		jogo.setSelecaoA(selecaoA);
		jogo.setSelecaoB(selecaoB);
		jogo.setEscalacaoA(escalacaoA);
		jogo.setEscalacaoB(escalacaoB);
		jogo.setLocal(local);
		jogo.setData(data);
		
		jogoDAO = new JogoDAOHibernate();
		jogoDAO.adicionar(jogo);
		
	}
	
	//UserStory#08
	public void cadastrarGol(){
		
	}
	
	//UserStory#09
	public void cadastrarSubstituicao(){
		
	}

}
