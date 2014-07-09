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
		
		jogadorDAO = new JogadorDAOHibernate();
		List<Jogador> lista = jogadorDAO.listar();
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
	public String consultarTecnicoSelecao(String nomeSelecao){
		
		Tecnico tecnico = null;
		selecaoDAO = new SelecaoDAOHibernate();
		Selecao selecao = selecaoDAO.buscar(nomeSelecao);
		tecnico = selecao.getTecnico();
		
		return tecnico.getNome();
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
	public List<Pais> listarPaisesCopa(int ano){
		
		List<Pais> lista = null;
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		for (int i = 0; i < copa.getSelecoes().size(); i++){
			Pais pais = copa.getSelecoes().get(i).getPais();
			lista.add(pais);
		}
		 ///// TO DO
		
		return lista;
	}
	
	//UserStory#18
	public String consultarPlacar(int ano, int id_jogo){
		
		String placar = null;
		/*int golsSelecaoA, golsSelecaoB;
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		List<Jogo> jogo = copa.getJogos();
		for (int i = 0; i < jogo.size(); i++){
			if (id_jogo == jogo.get(i).getId()){
				
			}
		}*/
		
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
