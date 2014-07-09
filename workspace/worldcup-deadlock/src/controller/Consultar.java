package controller;

import java.util.List;

import model.*;

public class Consultar {
	
	private PaisDAOHibernate paisDAO = null;
	private JogadorDAOHibernate jogadorDAO = null;
	private TecnicoDAOHibernate tecnicoDAO = null;
	private SelecaoDAOHibernate selecaoDAO = null;
	private CopaDAOHibernate copaDAO = null;
	private EscalacaoDAOHibernate escalacaoDAO = null;
	private JogoDAOHibernate jogoDAO = null;
	private GolDAOHibernate golDAO = null;
	
	//UserStory#10
	public List<Pais> listarTodosPaises(){
		
		paisDAO = new PaisDAOHibernate();
		List<Pais> lista = paisDAO.listar();
		return lista;
	}
	
	//UserStory#11
	public List<Jogador> listarTodosJogadores(){
		
		List<Jogador> lista = null;
		
		return lista;
	}
	
	//UserStory#12
	public List<Tecnico> listarTodosTecnicos(){
		
		tecnicoDAO = new TecnicoDAOHibernate();
		List<Tecnico> lista = tecnicoDAO.listar();
	
		return lista;
	}
	
	//UserStory#13
	@SuppressWarnings("null")
	public List<String> listarTodasSelecoes(){
		
		String selecao = null;
		List<String> lista = null;
		selecaoDAO = new SelecaoDAOHibernate();
		for(int i = 0; i < selecaoDAO.listar().size(); i++){
			selecao = new String(selecaoDAO.listar().get(i).getPais().getNome() + " de " + selecaoDAO.listar().get(i).getAno());
			lista.add(selecao);
		}
		return lista;
	}
	
	//UserStory#14
	public List<Jogador> listarJogadoresSelecao(String nomeSelecao){
		
		List<Jogador> lista = null;
		selecaoDAO = new SelecaoDAOHibernate();
		Selecao selecao = selecaoDAO.buscar(nomeSelecao);
		lista = selecao.getJogadores();
		
		return lista;
	}
	
	//UserStory#15
	public List<Tecnico> consultarTecnicoSelecao(){
		
		List<Tecnico> lista = null;
		
		return lista;
	}
	
	//UserStory#16
	public List<String> listarTodasCopas(){
		
		String copa = null;
		List<String> lista = null;
		copaDAO = new CopaDAOHibernate();
		for(int i = 0; i < copaDAO.listar().size(); i++){
			copa = new String("Copa do mundo de" + copaDAO.listar().get(i).getAno() + copaDAO.listar().get(i).getPais().getNome());
			lista.add(copa);
		}
		return lista;
		
		
		
	
	}
	
	//UserStory#17
	public List<Pais> listarPaisesCopa(){
		
		List<Pais> lista = null;
		
		return lista;
	}
	
	//UserStory#18
	public String consultarPlacar(){
		
		String placar = null;
		
		return placar;
	}
	
	//UserStory#19
	public List<String> listarJogosCopa(){
		
		String jogosCopa = null;
		List<String> lista = null;
		jogoDAO = new JogoDAOHibernate();
		for(int i = 0; i < jogoDAO.listar().size(); i++){
			jogosCopa = new String(jogoDAO.listar().get(i).getSelecaoA() + " " + jogoDAO.listar().get(i).getSelecaoA().getGols()
					+ " x " + jogoDAO.listar().get(i).getSelecaoB().getGols() + jogoDAO.listar().get(i).getSelecaoB());
			lista.add(jogosCopa);
		}
		return lista;
		
		

	}
	
	//UserStory#20
	public List<String> listarEscalacaoSelecaoJogo(){
		
		List<String> escalacao = null;
		
		return escalacao;
	}
	
	//UserStory#21
	public List<Substituicao> listarSubstituicoesJogo(){
		
		List<Substituicao> lista = null;
		
		return lista;
	}
	
	//UserStory#22
	public List<Gol> listarGolsJogo(){
		
		List<Gol> lista = null;
		
		return lista;
	}
	
	//UserStory#23
	public String consultarCaracteristicaJogadorCopa(){
		
		String caracteristica = null;
		
		return caracteristica;
	}
	
	//UserStory#24
	public int consultarQuantJogosSelecao(){
		
		int qnt = 0;
		
		return qnt;
	}
	
	//UserStory#25
	public int consultarQuantGolsCopa(){
		
		int qnt = 0;
		
		return qnt;
	}
	
	//UserStory#26
	public List<Jogo> consultarJogoMaiorGoleada(){
		
		Jogo jogo = null;
		
		return null;
	}
	
	//UserStory#27
	public List<Jogo> listarJogosEmpatadosCopa(){
		
		List<Jogo> lista = null;
		
		return lista;
	}
	
	//UserStory#28
	public List<Jogo> listarJogosGoleadas(){
		
		List<Jogo> lista = null;
		
		return lista;
	}

}
