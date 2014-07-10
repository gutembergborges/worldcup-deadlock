package controller;

import java.util.List;

import model.*;

public class Consultar {
	
	private PaisDAOHibernate paisDAO = null;
	private JogadorDAOHibernate jogadorDAO = null;
	private TecnicoDAOHibernate tecnicoDAO = null;
	private SelecaoDAOHibernate selecaoDAO = null;
	private CopaDAOHibernate copaDAO = null;
	private final EscalacaoDAOHibernate escalacaoDAO = null;
	private final JogoDAOHibernate jogoDAO = null;
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
	public String consultarPlacar(int ano, String selecaoA, String selecaoB){
		
		String placar = null;

		int golsSelecaoA = 0;
		int golsSelecaoB = 0;
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		List<Jogo> jogo = copa.getJogos();
		for (int i = 0; i < jogo.size(); i++){
			if (selecaoA.equals(jogo.get(i).getSelecaoA().getPais().getNome()) && selecaoB.equals(jogo.get(i).getSelecaoB().getPais())){
				golsSelecaoA = jogo.get(i).getSelecaoA().getGols().size();
				golsSelecaoB = jogo.get(i).getSelecaoB().getGols().size();
			}
		}
		
		placar = golsSelecaoA + "x" + golsSelecaoB;


		
		return placar;
	}
	
	//UserStory#19
	public List<String> listarJogosCopa(int ano){
		
		String jogosCopa = null;
		List<String> lista = null;
		
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		List<Jogo> jogo = copa.getJogos(); 
		
		for(int i = 0; i < jogo.size(); i++){
			jogosCopa = new String(jogo.get(i).getSelecaoA().getPais().getNome() + " " + jogo.get(i).getSelecaoA().getGols().size()
					+ "x" + jogo.get(i).getSelecaoB().getGols().size() + jogo.get(i).getSelecaoB().getPais().getNome());
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
	public List<Substituicao> listarSubstituicoesJogo(int ano, String selecaoA, String selecaoB){
		
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		Jogo jogo = null;
		for (int i = 0; i < copa.getJogos().size(); i++){
			if (selecaoA.equals(copa.getJogos().get(i).getSelecaoA().getPais().getNome()) && selecaoB.equals(copa.getJogos().get(i).getSelecaoB().getPais().getNome())){
				jogo = copa.getJogos().get(i);
			}
		}
		
		List<Substituicao> lista = null;
		
		for (int i = 0; i < jogo.getSubstituicoes().size(); i++){
			lista.add(jogo.getSubstituicoes().get(i));
		}		
		
		return lista;
	}
	
	//UserStory#22
	public List<String> listarGolsJogo(Jogo jogo){
		
		
		String golsJogo = null;
		List<String> lista = null;
		golDAO = new GolDAOHibernate();
		
		
		for(int i = 0; i < golDAO.listar().size(); i++){
			//if (jogo.getId() == 1) {
			
				golsJogo = new String("Gol" + golDAO.listar().get(i).getSelecao() + "," + golDAO.listar().get(i).getTempo()+ "," 
				+ golDAO.listar().get(i).getJogador()+ "," + golDAO.listar().get(i).getFoiContra());
					
			lista.add(golsJogo	);
			
			}
		
		return lista;
		
	}
		
	
	//UserStory#23
	public List<Object> consultarCaracteristicaJogadorCopa(int ano, String pais, String nome_jogador){
		
		copaDAO = new CopaDAOHibernate();
		Copa copa = null;
		List<Jogador> jogador = null;
		Jogador player = null;
		List<Object> caracteristicas = null;
		
		for (int i = 0; i < copaDAO.listar().size(); i++){
			if (ano == copaDAO.listar().get(i).getAno()){
				copa = copaDAO.listar().get(i);
			}
		}
		
		for (int i = 0; i < copa.getSelecoes().size(); i++){
			if (pais.equals(copa.getSelecoes().get(i).getPais().getNome())){
				jogador = copa.getSelecoes().get(i).getJogadores();
			}
		}
		
		for (int i = 0; i < jogador.size(); i++){
			if (nome_jogador.equals(jogador.get(i).getNome())){
				player = jogador.get(i);
			}
		}
		
		caracteristicas.add(player.getData_nascimento());
		caracteristicas.add(player.getNome());
		caracteristicas.add(player.getNumero());
		caracteristicas.add(player.getPosicao());
		caracteristicas.add(player.getSelecao());
		
		//String caracteristica = null;
		
		return caracteristicas;
	}
	
	//UserStory#24
	public int consultarQuantJogosSelecao(String pais){
		
		int qnt = 0;
		
		copaDAO = new CopaDAOHibernate();
		List<Copa> copa = copaDAO.listar(); 
		
		for (int i = 0; i < copa.size(); i++){
			
			for (int j = 0; j < copa.get(i).getSelecoes().size(); j++){
				
				if (pais.equals(copa.get(i).getSelecoes().get(j).getPais().getNome())){
					
					for (int k = 0; k < copa.get(i).getJogos().size(); k++){
						if (pais.equals(copa.get(i).getJogos().get(k).getSelecaoA().getPais().getNome()) || pais.equals(copa.get(i).getJogos().get(k).getSelecaoB().getPais().getNome())){
							
							qnt = qnt + 1;
									
						}
					}
					
				}
				
			}
							
		}
		
		return qnt;
	}
	
	//UserStory#25
	public String consultarQuantGolsCopa(int ano){
		
		String resultado = null;
		int qntGols = 0;
		int qntJogos = 0;
		copaDAO = new CopaDAOHibernate();
		Copa copa = null;
		Jogo jogo = null;
	
		
			for (int i = 0; i < copaDAO.listar().size(); i++){
					if (ano == copaDAO.listar().get(i).getAno()){
						copa = copaDAO.listar().get(i);
					}
			}
					
			for (int i = 0; i < copa.getJogos().size(); i++){
							
					qntGols = copa.getSelecoes().get(i).getGols().size();
					
					
			}	
			
			qntJogos = copa.getJogos().size();
			
			int media = qntGols/qntJogos;
			
			resultado = new String ("Total de gols:" + qntGols + "Mï¿½dia de gols por partida:" + media );
		
				
		return resultado;
	}
	
	//UserStory#26
	@SuppressWarnings({ "null", "unused" })
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
							jogosGoleada = null; //descarto uma possivel lista de jogos empatados com maior goleada, ja que achamos uma nova maior goleada
						}
						
						//Caso encontremos um jogo que tenha a mesma diferenca de gols que a maior diferenca registrada ate o momento...
						else if(diferenca == maiorDiferenca){
							if(jogosGoleada != null){ //Se a lista nao esta vazia, significa que nao preciso adicionar o jogo anterior, pois ele ja esta la 
								jogosGoleada.add(copas.get(i).getJogos().get(j)); 
							}
							
							else{ //Se esta vazia, preciso colocar jogoGoleada na lista tambem pois ele esta empatado com o atual
								jogosGoleada.add(jogoGoleada);
								jogosGoleada.add(copas.get(i).getJogos().get(j));
								jogosGoleada = null; //zero ele pq ja coloquei na lista
							}
							
						}
						
					}	
				}		
			}
		}
		
		if(jogoGoleada != null){
			jogosGoleada.add(jogoGoleada);
			return jogosGoleada;
		}
		else if(jogosGoleada != null){
			return jogosGoleada;
		}
		else{
			return null;
		}
	}
	
	//UserStory#27
	public List<String> listarJogosEmpatadosCopa(int ano){
		
		// List<Jogo> lista = null;
		
		String jogoEmpatado = null;
		List<String> lista = null;
		
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		List<Jogo> jogo = copa.getJogos();
			
		for(int i = 0; i < jogo.size(); i++){
			
			if(jogo.get(i).getSelecaoA().getGols().size() == jogo.get(i).getSelecaoB().getGols().size()){
				
				jogoEmpatado = new String(jogo.get(i).getSelecaoA().getPais().getNome() + " " + jogo.get(i).getSelecaoA().getGols().size()
						+ " x " + jogo.get(i).getSelecaoB().getGols().size() + jogo.get(i).getSelecaoB().getPais().getNome());
				lista.add(jogoEmpatado);
				
			}
		}
		
		return lista;
	}
	
	//UserStory#28
	public List<String> listarJogosGoleadas(){
		
		//List<Jogo> lista = null;
		
		copaDAO = new CopaDAOHibernate();
		List<Copa> copa = copaDAO.listar();
		List<Jogo> jogo = null;
		int vantagem = 0;
		String jogo_edicao = null;
		List<String> lista_string = null;
		
		for (int i = 0; i < copa.size(); i++){
			
			jogo = copa.get(i).getJogos();
			
			for (int j = 0; j < jogo.size(); j++){
				
				int golsSelecaoA = jogo.get(j).getSelecaoA().getGols().size();
				int golsSelecaoB = jogo.get(j).getSelecaoB().getGols().size();
				
				vantagem = golsSelecaoA - golsSelecaoB;
				
				if (vantagem >= 3 || vantagem <= -3){
				
					//lista.add(jogo.get(j));
					
					jogo_edicao = jogo.get(j).getSelecaoA().getPais().getNome() + " x " + jogo.get(j).getSelecaoB().getPais().getNome() + " - Copa de " + copa.get(i).getAno();
					
					lista_string.add(jogo_edicao);
					
				}
				
			}
			
		}
		
		return lista_string;
	}
	
	//UserStory#29
	public List<Selecao> consultarClassificacao(Copa copa){
		
		List<Selecao> lista = null;
		
		return lista;
	}
	
	//UserStory#41 (Substitui a 30 pela 41)
	@SuppressWarnings({ "unused", "null" })
	public List<Jogador> consultarJogadorMaisGolsPartida(Jogo jogo){
		
		List<Jogador> jogadores = null;
		Jogador jogadorMaisGols = null;
		int maisGols = 0; //Armazena a maior quantidade de gols que um jogador fez na partida
		
		for(int i = 0; i < jogo.getGols().size(); i++){
					
			//Pega o jogador que fez um dos gols
			Jogador jogador_aux = jogo.getGols().get(i).getJogador();
					
			
			int aux = 0; //conta quantos gols o jogador fez
			//Faco outro laco e comparo com a lista de gols para saber se ele fez outros gols
			for(int j = 0; j < jogo.getGols().size(); j++){
							
				//A cada vez que o autor do gol da lista eh o jogador em questao, o contador dele é incrementado
				if(jogo.getGols().get(j).getJogador().getId() == jogador_aux.getId()){
					aux++;
				}
						
			}
					
			//Agora comparo se a quantidade de gols que ele fez é a maior ou igual a detectada ate agora no jogo
			if(aux > maisGols){ //Se for maior...
				maisGols = aux; //...a variavel maisGols é atualizada
				jogadorMaisGols =  jogador_aux; //guardo o jogador que fez mais gols
				jogadores = null; //... e zero uma possivel lista de jogadores que estavam empatados
			}	
			
			//Se for igual...
			else if(aux == maisGols){
				
				//Adiciono os jogadores empatados na lista
				if(jogadores != null){ //Se a lista nao esta vazia, significa que nao preciso adicionar o jogador anterior, pois ele ja esta la 
					jogadores.add(jogador_aux); 
				}
				
				else{ //Se esta vazia, preciso colocar o jogadorMaisGols na lista tambem pois ele esta empatado com o atual
					jogadores.add(jogadorMaisGols);
					jogadores.add(jogador_aux);
					jogadorMaisGols = null; //zero ele pq ja coloquei na lista
				}
				
			}
			
		} //O processo se repete ate que todos os gols da lista sejam analisados		
			
		if(jogadorMaisGols != null){
			jogadores.add(jogadorMaisGols);
			return jogadores;
		}
		else if(jogadores != null){
			return jogadores;
		}
		else{
			return null;
		}
	}
	
	//UserStory#31
	public List<String> consultarMediaIdadeCopa(Copa copa){
		//Obs: retornar lista de strings onde cada string ï¿½ referente a uma selecao da copa (a mï¿½dia ï¿½ de cada selecao da copa)
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#32
	public List<String> consultarFinais(){
	 		
		copaDAO = new CopaDAOHibernate();
		List<Copa> copa = copaDAO.listar();
		
		List <Integer> jogo_final = null; //copa.size() - 1;
		List <Jogo> jogo = null;
		
		for (int i = 0; i < copa.size(); i++){
			
			jogo = copa.get(i).getJogos();
			jogo_final.add(jogo.size());
			
		}

		String selecaoA = null;
		String selecaoB = null;

		int golsSelecaoA = 0;
		int golsSelecaoB = 0;

		String final_copa = null;

		List<String> lista = null;


		for(int i = 0; i < copa.size(); i++){

			selecaoA = copa.get(i).getJogos().get(jogo_final.get(i)).getSelecaoA().getPais().getNome();		
			selecaoB = copa.get(i).getJogos().get(jogo_final.get(i)).getSelecaoB().getPais().getNome();
			
			golsSelecaoA = copa.get(i).getJogos().get(jogo_final.get(i)).getSelecaoA().getGols().size();
			golsSelecaoB = copa.get(i).getJogos().get(jogo_final.get(i)).getSelecaoB().getGols().size();

			final_copa = "Final: " + selecaoA + " x " + selecaoB + " - Placar: " + golsSelecaoA + " x " + golsSelecaoB;

			lista.add(final_copa);

		}


		
	 		
	 	return lista;
	 

	}
	
	//UserStory#33
	public List<Tecnico> consultarTecnicosCampeoes(){
		
		List<Tecnico> lista = null;
		
		return lista;
	}
	
	//UserStory#34
	public List<String> consultarGolsContra(){
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#35
	public List<String> consultarPaisesSedeCampeao(){
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#36
	public List<String> consultarPaisesMaisTitulos(){
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#37
	public int consultarQntParticipacoesCopa(Pais pais){
		
		int quantidade = 0;
		
		return quantidade;
	}
	
	//UserStory#38
	public List<String> listarPaisesMaisParticipacoes(){
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#39
	public List<String> consultarMaioresVice(){
		
		List<String> lista = null;
		
		return lista;
	}
	
	//UserStory#40
	public List<String> consultarPaisesMaisDerrotados(){
		
		List<String> lista = null;
		
		return lista;
	}

}
