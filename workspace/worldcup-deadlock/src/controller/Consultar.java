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
		
		List<Pais> lista = null;
		
		return lista;
	}
	
	//UserStory#11
	public List<Jogador> listarTodosJogadores(){
		
		List<Jogador> lista = null;
		
		return lista;
	}
	
	//UserStory#12
	public List<Tecnico> listarTodosTecnicos(){
		
		List<Tecnico> lista = null;
		
		return lista;
	}
	
	//UserStory#13
	public List<Selecao> listarTodasSelecoes(){
		
		List<Selecao> lista = null;
		
		return lista;
	}
	
	//UserStory#14
	public List<Jogador> listarJogadoresSelecao(){
		
		List<Jogador> lista = null;
		
		return lista;
	}
	
	//UserStory#15
	public List<Tecnico> consultarTecnicoSelecao(){
		
		List<Tecnico> lista = null;
		
		return lista;
	}
	
	//UserStory#16
	public List<Copa> listarTodasCopas(){
		
		List<Copa> lista = null;
		
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
	public List<Jogo> listarJogosCopa(){
		
		List<Jogo> lista = null;
		
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
