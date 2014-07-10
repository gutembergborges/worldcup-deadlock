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
	@SuppressWarnings("null")
	public List<String> listarEscalacaoSelecaoJogo(Jogo jogo, String selecao){
		
		List<String> escalacao = null;
		String jogador = null;
		String posicao = null;
		
		if(jogo.getSelecaoA().getPais().getNome().equals(selecao)){
			for(int i = 0; i < jogo.getEscalacaoA().getJogadores().size(); i++){
				jogador = new String(jogo.getEscalacaoA().getJogadores().get(i).getNome());
				posicao = new String(jogo.getEscalacaoA().getJogadores().get(i).getPosicao().getFuncao());
				escalacao.add(posicao + " - " + jogador);				
			}
			return escalacao;
		}
		
		else if(jogo.getSelecaoB().getPais().getNome().equals(selecao)){
			for(int i = 0; i < jogo.getEscalacaoB().getJogadores().size(); i++){
				jogador = new String(jogo.getEscalacaoB().getJogadores().get(i).getNome());
				posicao = new String(jogo.getEscalacaoB().getJogadores().get(i).getPosicao().getFuncao());
				escalacao.add(posicao + " - " + jogador);				
			}
			return escalacao;
		}
		
		else{
			return null;
		}

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
	@SuppressWarnings("null")
	public List<Jogo> consultarJogoMaiorGoleada(){
		
		List<Jogo> jogosGoleada = null;
		Jogo jogoGoleada = null;
		copaDAO = new CopaDAOHibernate();
		List<Copa> copas = copaDAO.listar();
		
		int maiorDiferenca = 0;
		
		//Varre a lista de copas
		for(int i = 0; i < copas.size(); i++){
			//Varre a lista de jogos da copa
			for(int j = 0; j < copas.get(i).getJogos().size(); j++){
				
				//Pega os ids das selecoes do jogo em questao
				Long selecaoA = copas.get(i).getJogos().get(j).getSelecaoA().getId();
				Long selecaoB = copas.get(i).getJogos().get(j).getSelecaoB().getId();
				
				int qntGolsA = 0; //contador de gols da selecaoA
				int qntGolsB = 0; //contador de gols da selecaoB
				int diferenca = 0; //diferenca de gols entre as duas selecoes
				
				//Se a partida teve gols...
				if(copas.get(i).getJogos().get(j).getGols().size() != 0){
					//Varre a lista de gols do jogo 
					for(int k = 0; k < copas.get(i).getJogos().get(j).getGols().size(); k++){
						//Se for gol da selecaoA
						if(copas.get(i).getJogos().get(j).getGols().get(k).getSelecao().getId() == selecaoA){
							qntGolsA++;
						}
						//Se for gol da selecaoB
						else if(copas.get(i).getJogos().get(j).getGols().get(k).getSelecao().getId() == selecaoB){
							qntGolsB++;
						}
					}
					
					//Verifica a diferenca de gols no jogo
					if(qntGolsA > qntGolsB){
						diferenca = qntGolsA - qntGolsB;
					}
					
					else if(qntGolsB > qntGolsA){
						diferenca = qntGolsB - qntGolsA;
					}
					
					/* Se existir diferenca, compara a diferenca com a maior diferenca registrada ate o momento
					* afim de encontrar a maior goleada
					*/ 
					if(diferenca != 0){
						//Se encontramos uma diferenca maior que a registrada, temos uma nova maior goleada
						if(diferenca > maiorDiferenca){
							maiorDiferenca = diferenca; //registra a nova maior diferenca
							jogoGoleada = copas.get(i).getJogos().get(j); //guardo o jogo de maior goleada encontrado
							jogosGoleada.clear();; //descarto uma possivel lista de jogos empatados com maior goleada, ja que achamos uma nova maior goleada
						}
						
						//Caso encontremos um jogo que tenha a mesma diferenca de gols que a maior diferenca registrada ate o momento...
						else if(diferenca == maiorDiferenca){
							jogosGoleada.add(jogoGoleada); //adiciono o jogo que tinha a maior goleada sozinho numa lista
							jogosGoleada.add(copas.get(i).getJogos().get(j)); //adiciono o novo jogo encontrado
							jogoGoleada = null; //anulo o objeto que guarda o jogo com maior goleada, pois agora temos uma lista de jogos e não 1 jogo apenas
						}
						
					}	
				}		
			}
		}
		
		if(jogoGoleada != null){
			jogosGoleada.add(jogoGoleada);
			return jogosGoleada;
		}
		else if(!jogosGoleada.isEmpty()){
			return jogosGoleada;
		}
		else{
			return null;
		}
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
	
	//UserStory#29
	public List<Selecao> consultarClassificacao(Copa copa){
		
		List<Selecao> lista = null;
		
		return lista;
	}
	
	//UserStory#30
	public List<String> consultarArtilheirosGeral(Copa copa){
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#31
	public List<String> consultarMediaIdadeCopa(Copa copa){
		//Obs: retornar lista de strings onde cada string é referente a uma selecao da copa (a média é de cada selecao da copa)
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#32
	public List<String> consultarFinais(){
		
		List<String> lista = null;
		
		return lista;
	}

}
