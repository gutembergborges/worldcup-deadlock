package controller;

import java.util.Calendar;
import java.util.Date;

import model.Jogador;
import model.JogadorDAOHibernate;
import model.Jogo;
import model.JogoDAOHibernate;
import model.Pais;
import model.PaisDAOHibernate;
import model.Posicao;
import model.Selecao;
import model.SelecaoDAOHibernate;

public class Teste {

	public static void main(String[] args) {
		
	//	Pais pais = new Pais();
	//	pais.setNome("Brasil");
	//	pais.setContinente("America do Sul");
		
	//	PaisDAOHibernate paisHibernate = new PaisDAOHibernate();
	//	paisHibernate.adicionar(pais);
		
	//	Integer ano = 2002;
		
	//	Cadastrar cadastro = new Cadastrar();
	//	cadastro.cadastrarCopa(ano, pais);
		
	/*	Calendar calendar = Calendar.getInstance();
		calendar.set(1990, 11, 14);
		
		boolean foiContra = false;
		*/
		Jogo jogo = new Jogo();
		jogo.setLocal("Salvador");
		
		JogoDAOHibernate jogoDAO = new JogoDAOHibernate();
		jogoDAO.adicionar(jogo);
		
	/*	Jogador jogador = new Jogador();
		
		jogador.setNome("Roquelson");
		jogador.setNumero(13);
		jogador.setData_nascimento(calendar);
		
		JogadorDAOHibernate jogadorHibernate = new JogadorDAOHibernate();
		jogadorHibernate.adicionar(jogador);
		
		Selecao selecao = new Selecao();
		selecao.setAno(2010);
		selecao.setGrupo(5);
		selecao.setPosicao(1);
		
		SelecaoDAOHibernate selecaoHibernate = new SelecaoDAOHibernate();
		selecaoHibernate.adicionar(selecao);
		
		Date tempo = new Date();
		tempo.setHours(0);
		tempo.setMinutes(30);
		tempo.setSeconds(45);
		
		Cadastrar cadastro = new Cadastrar();
		cadastro.cadastrarGol(foiContra, jogador, jogo, selecao, tempo);
		
		//String nome = "Jerico";
	//	Integer numero = 24;
		//Selecao selecao = new Selecao();
		
	//	data.setYear(1990);
	//	data.setMonth(02);
		//data.setDate(14);
	//	System.out.println("Data nascimento:" + " " + data.getDate() + "/" + data.getMonth() + "/" + data.getYear());
		
	//	Calendar calendar = Calendar.getInstance();
	//	calendar.set(1990, 11, 14);
		
	//	Cadastrar cadastro = new Cadastrar();
	//	cadastro.cadastrarJogador(calendar, nome, numero, null, null);
		*/
	}

}
