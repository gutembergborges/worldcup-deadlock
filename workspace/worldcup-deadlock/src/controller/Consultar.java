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

	// UserStory#10
	public List<Pais> listarTodosPaises() {

		paisDAO = new PaisDAOHibernate();
		List<Pais> lista = paisDAO.listar();
		return lista;
	}

	// UserStory#11
	public List<Jogador> listarTodosJogadores() {

		jogadorDAO = new JogadorDAOHibernate();
		List<Jogador> lista = jogadorDAO.listar();
		return lista;
	}

	// UserStory#12
	public List<Tecnico> listarTodosTecnicos() {

		tecnicoDAO = new TecnicoDAOHibernate();
		List<Tecnico> lista = tecnicoDAO.listar();

		return lista;
	}

	// UserStory#13
	@SuppressWarnings("null")
	public List<String> listarTodasSelecoes() {

		String selecao = null;
		List<String> lista = null;
		selecaoDAO = new SelecaoDAOHibernate();
		for (int i = 0; i < selecaoDAO.listar().size(); i++) {
			selecao = new String(selecaoDAO.listar().get(i).getPais().getNome()
					+ " de " + selecaoDAO.listar().get(i).getAno());
			lista.add(selecao);
		}
		return lista;
	}

	// UserStory#14
	public List<Jogador> listarJogadoresSelecao(String nomeSelecao) {

		List<Jogador> lista = null;
		selecaoDAO = new SelecaoDAOHibernate();
		Selecao selecao = selecaoDAO.buscar(nomeSelecao);
		lista = selecao.getJogadores();

		return lista;
	}

	// UserStory#15
	public String consultarTecnicoSelecao(String nomeSelecao) {

		Tecnico tecnico = null;
		selecaoDAO = new SelecaoDAOHibernate();
		Selecao selecao = selecaoDAO.buscar(nomeSelecao);
		tecnico = selecao.getTecnico();

		return tecnico.getNome();
	}

	// UserStory#16
	public List<String> listarTodasCopas() {

		String copa = null;
		List<String> lista = null;
		copaDAO = new CopaDAOHibernate();
		for (int i = 0; i < copaDAO.listar().size(); i++) {
			copa = new String("Copa do mundo de"
					+ copaDAO.listar().get(i).getAno()
					+ copaDAO.listar().get(i).getPais().getNome());
			lista.add(copa);
		}
		return lista;

	}

	// UserStory#17
	public List<Pais> listarPaisesCopa(int ano) {

		List<Pais> lista = null;
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		for (int i = 0; i < copa.getSelecoes().size(); i++) {
			Pais pais = copa.getSelecoes().get(i).getPais();
			lista.add(pais);
		}
		// /// TO DO

		return lista;
	}

	// UserStory#18
	public String consultarPlacar(int ano, String selecaoA, String selecaoB) {

		String placar = null;

		int golsSelecaoA = 0;
		int golsSelecaoB = 0;
		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		List<Jogo> jogo = copa.getJogos();
		for (int i = 0; i < jogo.size(); i++) {
			if (selecaoA.equals(jogo.get(i).getSelecaoA().getPais().getNome())
					&& selecaoB.equals(jogo.get(i).getSelecaoB().getPais())) {
				golsSelecaoA = jogo.get(i).getSelecaoA().getGols().size();
				golsSelecaoB = jogo.get(i).getSelecaoB().getGols().size();
			}
		}

		placar = golsSelecaoA + "x" + golsSelecaoB;

		return placar;
	}

	// UserStory#19
	public List<String> listarJogosCopa(int ano) {

		String jogosCopa = null;
		List<String> lista = null;

		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		List<Jogo> jogo = copa.getJogos();

		for (int i = 0; i < jogo.size(); i++) {
			jogosCopa = new String(jogo.get(i).getSelecaoA().getPais()
					.getNome()
					+ " "
					+ jogo.get(i).getSelecaoA().getGols().size()
					+ "x"
					+ jogo.get(i).getSelecaoB().getGols().size()
					+ jogo.get(i).getSelecaoB().getPais().getNome());
			lista.add(jogosCopa);
		}

		return lista;

	}

	// UserStory#20
	@SuppressWarnings("null")
	public List<String> listarEscalacaoSelecaoJogo(Jogo jogo, String selecao) {

		List<String> escalacao = null;
		String jogador = null;
		String posicao = null;

		if (jogo.getSelecaoA().getPais().getNome().equals(selecao)) {
			for (int i = 0; i < jogo.getEscalacaoA().getJogadores().size(); i++) {
				jogador = new String(jogo.getEscalacaoA().getJogadores().get(i)
						.getNome());
				posicao = new String(jogo.getEscalacaoA().getJogadores().get(i)
						.getPosicao().getFuncao());
				escalacao.add(posicao + "   " + jogador);
			}
			return escalacao;
		}

		else if (jogo.getSelecaoB().getPais().getNome().equals(selecao)) {
			for (int i = 0; i < jogo.getEscalacaoB().getJogadores().size(); i++) {
				jogador = new String(jogo.getEscalacaoB().getJogadores().get(i)
						.getNome());
				posicao = new String(jogo.getEscalacaoB().getJogadores().get(i)
						.getPosicao().getFuncao());
				escalacao.add(posicao + "   " + jogador);
			}
			return escalacao;
		}

		else {
			return null;
		}

	}

	// UserStory#21
	public List<Substituicao> listarSubstituicoesJogo(int ano, String selecaoA,
			String selecaoB) {

		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		Jogo jogo = null;
		for (int i = 0; i < copa.getJogos().size(); i++) {
			if (selecaoA.equals(copa.getJogos().get(i).getSelecaoA().getPais()
					.getNome())
					&& selecaoB.equals(copa.getJogos().get(i).getSelecaoB()
							.getPais().getNome())) {
				jogo = copa.getJogos().get(i);
			}
		}

		List<Substituicao> lista = null;

		for (int i = 0; i < jogo.getSubstituicoes().size(); i++) {
			lista.add(jogo.getSubstituicoes().get(i));
		}

		return lista;
	}

	// UserStory#22
	public List<String> listarGolsJogo(Jogo jogo) {

		String golsJogo = null;
		List<String> lista = null;
		golDAO = new GolDAOHibernate();

		for (int i = 0; i < golDAO.listar().size(); i++) {
			// if (jogo.getId() == 1) {

			golsJogo = new String("Gol" + golDAO.listar().get(i).getSelecao()
					+ "," + golDAO.listar().get(i).getTempo() + ","
					+ golDAO.listar().get(i).getJogador() + ","
					+ golDAO.listar().get(i).getFoiContra());

			lista.add(golsJogo);

		}

		return lista;

	}

	// UserStory#23
	public List<Object> consultarCaracteristicaJogadorCopa(int ano,
			String pais, String nome_jogador) {

		copaDAO = new CopaDAOHibernate();
		Copa copa = null;
		List<Jogador> jogador = null;
		Jogador player = null;
		List<Object> caracteristicas = null;

		for (int i = 0; i < copaDAO.listar().size(); i++) {
			if (ano == copaDAO.listar().get(i).getAno()) {
				copa = copaDAO.listar().get(i);
			}
		}

		for (int i = 0; i < copa.getSelecoes().size(); i++) {
			if (pais.equals(copa.getSelecoes().get(i).getPais().getNome())) {
				jogador = copa.getSelecoes().get(i).getJogadores();
			}
		}

		for (int i = 0; i < jogador.size(); i++) {
			if (nome_jogador.equals(jogador.get(i).getNome())) {
				player = jogador.get(i);
			}
		}

		caracteristicas.add(player.getDataNascimento());
		caracteristicas.add(player.getNome());
		caracteristicas.add(player.getNumero());
		caracteristicas.add(player.getPosicao());
		caracteristicas.add(player.getSelecao());

		// String caracteristica = null;

		return caracteristicas;
	}

	// UserStory#24
	public int consultarQuantJogosSelecao(String pais) {

		int qnt = 0;

		copaDAO = new CopaDAOHibernate();
		List<Copa> copa = copaDAO.listar();

		for (int i = 0; i < copa.size(); i++) {

			for (int j = 0; j < copa.get(i).getSelecoes().size(); j++) {

				if (pais.equals(copa.get(i).getSelecoes().get(j).getPais()
						.getNome())) {

					for (int k = 0; k < copa.get(i).getJogos().size(); k++) {
						if (pais.equals(copa.get(i).getJogos().get(k)
								.getSelecaoA().getPais().getNome())
								|| pais.equals(copa.get(i).getJogos().get(k)
										.getSelecaoB().getPais().getNome())) {

							qnt = qnt + 1;

						}
					}

				}

			}

		}

		return qnt;
	}

	// UserStory#25
	public String consultarQuantGolsCopa(int ano) {

		String resultado = null;
		int qntGols = 0;
		int qntJogos = 0;
		copaDAO = new CopaDAOHibernate();
		Copa copa = null;
		Jogo jogo = null;

		for (int i = 0; i < copaDAO.listar().size(); i++) {
			if (ano == copaDAO.listar().get(i).getAno()) {
				copa = copaDAO.listar().get(i);
			}
		}

		for (int i = 0; i < copa.getJogos().size(); i++) {

			qntGols = copa.getSelecoes().get(i).getGols().size();

		}

		qntJogos = copa.getJogos().size();

		int media = qntGols / qntJogos;

		resultado = new String("Total de gols:" + qntGols
				+ "Media de gols por partida:" + media);

		return resultado;
	}

	// UserStory#26
	@SuppressWarnings({ "null", "unused" })
	public List<Jogo> consultarJogoMaiorGoleada() {

		List<Jogo> jogosGoleada = null;
		Jogo jogoGoleada = null;
		copaDAO = new CopaDAOHibernate();
		List<Copa> copas = copaDAO.listar();

		int maiorDiferenca = 0;

		// Varre a lista de copas
		for (int i = 0; i < copas.size(); i++) {
			// Varre a lista de jogos da copa
			for (int j = 0; j < copas.get(i).getJogos().size(); j++) {

				// Pega os ids das selecoes do jogo em questao
				Long selecaoA = copas.get(i).getJogos().get(j).getSelecaoA()
						.getId();
				Long selecaoB = copas.get(i).getJogos().get(j).getSelecaoB()
						.getId();

				int qntGolsA = 0; // contador de gols da selecaoA
				int qntGolsB = 0; // contador de gols da selecaoB
				int diferenca = 0; // diferenca de gols entre as duas selecoes

				// Se a partida teve gols...
				if (copas.get(i).getJogos().get(j).getGols().size() != 0) {
					// Varre a lista de gols do jogo
					for (int k = 0; k < copas.get(i).getJogos().get(j)
							.getGols().size(); k++) {
						// Se for gol da selecaoA
						if (copas.get(i).getJogos().get(j).getGols().get(k)
								.getSelecao().getId() == selecaoA) {
							qntGolsA++;
						}
						// Se for gol da selecaoB
						else if (copas.get(i).getJogos().get(j).getGols()
								.get(k).getSelecao().getId() == selecaoB) {
							qntGolsB++;
						}
					}

					// Verifica a diferenca de gols no jogo
					if (qntGolsA > qntGolsB) {
						diferenca = qntGolsA - qntGolsB;
					}

					else if (qntGolsB > qntGolsA) {
						diferenca = qntGolsB - qntGolsA;
					}

					/*
					 * Se existir diferenca, compara a diferenca com a maior
					 * diferenca registrada ate o momento afim de encontrar a
					 * maior goleada
					 */
					if (diferenca != 0) {
						// Se encontramos uma diferenca maior que a registrada,
						// temos uma nova maior goleada
						if (diferenca > maiorDiferenca) {
							maiorDiferenca = diferenca; // registra a nova maior
														// diferenca
							jogoGoleada = copas.get(i).getJogos().get(j); // guardo
																			// o
																			// jogo
																			// de
																			// maior
																			// goleada
																			// encontrado
							jogosGoleada = null; // descarto uma possivel lista
													// de jogos empatados com
													// maior goleada, ja que
													// achamos uma nova maior
													// goleada
						}

						// Caso encontremos um jogo que tenha a mesma diferenca
						// de gols que a maior diferenca registrada ate o
						// momento...
						else if (diferenca == maiorDiferenca) {
							if (jogosGoleada != null) { // Se a lista nao esta
														// vazia, significa que
														// nao preciso adicionar
														// o jogo anterior, pois
														// ele ja esta la
								jogosGoleada
										.add(copas.get(i).getJogos().get(j));
							}

							else { // Se esta vazia, preciso colocar jogoGoleada
									// na lista tambem pois ele esta empatado
									// com o atual
								jogosGoleada.add(jogoGoleada);
								jogosGoleada
										.add(copas.get(i).getJogos().get(j));
								jogosGoleada = null; // zero ele pq ja coloquei
														// na lista
							}

						}

					}
				}
			}
		}

		if (jogoGoleada != null) {
			jogosGoleada.add(jogoGoleada);
			return jogosGoleada;
		} else if (jogosGoleada != null) {
			return jogosGoleada;
		} else {
			return null;
		}
	}

	// UserStory#27
	public List<String> listarJogosEmpatadosCopa(int ano) {

		// List<Jogo> lista = null;

		String jogoEmpatado = null;
		List<String> lista = null;

		copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(ano);
		List<Jogo> jogo = copa.getJogos();

		for (int i = 0; i < jogo.size(); i++) {

			if (jogo.get(i).getSelecaoA().getGols().size() == jogo.get(i)
					.getSelecaoB().getGols().size()) {

				jogoEmpatado = new String(jogo.get(i).getSelecaoA().getPais()
						.getNome()
						+ " "
						+ jogo.get(i).getSelecaoA().getGols().size()
						+ " x "
						+ jogo.get(i).getSelecaoB().getGols().size()
						+ jogo.get(i).getSelecaoB().getPais().getNome());
				lista.add(jogoEmpatado);

			}
		}

		return lista;
	}

	// UserStory#28
	public List<String> listarJogosGoleadas() {

		// List<Jogo> lista = null;

		copaDAO = new CopaDAOHibernate();
		List<Copa> copa = copaDAO.listar();
		List<Jogo> jogo = null;
		int vantagem = 0;
		String jogo_edicao = null;
		List<String> lista_string = null;

		for (int i = 0; i < copa.size(); i++) {

			jogo = copa.get(i).getJogos();

			for (int j = 0; j < jogo.size(); j++) {

				int golsSelecaoA = jogo.get(j).getSelecaoA().getGols().size();
				int golsSelecaoB = jogo.get(j).getSelecaoB().getGols().size();

				vantagem = golsSelecaoA - golsSelecaoB;

				if (vantagem >= 3 || vantagem <= 3) {

					// lista.add(jogo.get(j));

					jogo_edicao = jogo.get(j).getSelecaoA().getPais().getNome()
							+ " x "
							+ jogo.get(j).getSelecaoB().getPais().getNome()
							+ "   Copa de " + copa.get(i).getAno();

					lista_string.add(jogo_edicao);

				}

			}

		}

		return lista_string;
	}

	// UserStory#29
	public List<String> consultarClassificacao(int ano) {

		List<String> lista = null;
		Copa copa = null;
		copaDAO = new CopaDAOHibernate();
		paisDAO = new PaisDAOHibernate();
		// linha 0: pais (id) | linha 1: posicao. Cada coluna e um pais

		Long[][] titulos = new Long[2][paisDAO.listar().size()];

		// Adiciona todos os paises cadastrados na matriz, inicializando a
		// quantidade de titulos com zero
		for (int i = 0; i < paisDAO.listar().size(); i++) {
			titulos[0][i] = paisDAO.listar().get(i).getId();
			titulos[1][i] = (long) 0;
		}

		// Varre todas as copas...
		for (int i = 0; i < copaDAO.listar().size(); i++) {
			// Varre todas as selecoes da copa...
			if (ano == copaDAO.listar().get(i).getAno()) {

				for (int j = 0; j < copaDAO.listar().get(i).getSelecoes()
						.size(); j++) {
					// Pega as posicoes...
					copaDAO.listar().get(i).getSelecoes().get(j).getPosicao();
					// Varre a matriz de titulos...
					for (int k = 0; k < paisDAO.listar().size(); k++) {
						// incrementa a quantidade de titulos na matriz, na
						// posicao referente ao pais em questao
						if (titulos[0][k] == copaDAO.listar().get(i)
								.getSelecoes().get(j).getPais().getId()) {
							titulos[1][k]++;
							break;
						}
					}
				}
			}
		}

		// Agora que temos uma matriz que guarda a posicao de cada
		// pais, vamos ordenar ele em ordem decrescente
		for (int i = 0; i < paisDAO.listar().size(); i++) {
			for (int j = i + 1; j < paisDAO.listar().size(); j++) {
				if (titulos[1][i] > titulos[1][j]) {
					long aux = titulos[1][i];
					titulos[1][i] = titulos[1][j];
					titulos[1][j] = aux;
				}
			}
		}

		// Vetor ordenado em ordem crescente
		for (int i = 0; i < paisDAO.listar().size(); i++) {
			// Buscamos o nome do pais a partir do seu Id..
			String nome = null;
			for (int j = 0; j < paisDAO.listar().size(); j++) {
				// pego o nome...
				if (titulos[0][i] == paisDAO.listar().get(j).getId()) {
					nome = new String(paisDAO.listar().get(j).getNome());
					break;
				}
			}

			// ...e finalmente adiciono na lista de strings informando o nome e
			// a quantidade de titulos.
			lista.add(nome + ": " + titulos[1][i].intValue() + " lugar"); // Exemplo:
																			// "Brasil: 5 lugar."
		}

		return lista;
	}

	// UserStory#41 (Substitui a 30 pela 41)
	@SuppressWarnings({ "unused", "null" })
	public List<Jogador> consultarJogadorMaisGolsPartida(Jogo jogo) {

		List<Jogador> jogadores = null;
		Jogador jogadorMaisGols = null;
		int maisGols = 0; // Armazena a maior quantidade de gols que um jogador
							// fez na partida

		for (int i = 0; i < jogo.getGols().size(); i++) {

			// Pega o jogador que fez um dos gols
			Jogador jogador_aux = jogo.getGols().get(i).getJogador();

			int aux = 0; // conta quantos gols o jogador fez
			// Faco outro laco e comparo com a lista de gols para saber se ele
			// fez outros gols
			for (int j = 0; j < jogo.getGols().size(); j++) {

				// A cada vez que o autor do gol da lista eh o jogador em
				// questao, o contador dele eh incrementado
				if (jogo.getGols().get(j).getJogador().getId() == jogador_aux
						.getId()) {
					aux++;
				}

			}

			// Agora comparo se a quantidade de gols que ele fez � a maior ou
			// igual a detectada ate agora no jogo
			if (aux > maisGols) { // Se for maior...
				maisGols = aux; // ...a variavel maisGols � atualizada
				jogadorMaisGols = jogador_aux; // guardo o jogador que fez mais
												// gols
				jogadores = null; // ... e zero uma possivel lista de jogadores
									// que estavam empatados
			}

			// Se for igual...
			else if (aux == maisGols) {

				// Adiciono os jogadores empatados na lista
				if (jogadores != null) { // Se a lista nao esta vazia, significa
											// que nao preciso adicionar o
											// jogador anterior, pois ele ja
											// esta la
					jogadores.add(jogador_aux);
				}

				else { // Se esta vazia, preciso colocar o jogadorMaisGols na
						// lista tambem pois ele esta empatado com o atual
					jogadores.add(jogadorMaisGols);
					jogadores.add(jogador_aux);
					jogadorMaisGols = null; // zero ele pq ja coloquei na lista
				}

			}

		} // O processo se repete ate que todos os gols da lista sejam
			// analisados

		if (jogadorMaisGols != null) {
			jogadores.add(jogadorMaisGols);
			return jogadores;
		} else if (jogadores != null) {
			return jogadores;
		} else {
			return null;
		}
	}

	// UserStory#31
	@SuppressWarnings("deprecation")
	public List<String> consultarMediaIdadeCopa(int ano) {

		List<String> lista = null; // cada string contera o nome da selecao e a
									// media de idade. ex: "BRASIL: 25 anos."
		copaDAO = new CopaDAOHibernate();

		for (int i = 0; i < copaDAO.listar().size(); i++) {

			if (copaDAO.listar().get(i).getAno() == ano) {

				for (int j = 0; j < copaDAO.listar().get(i).getSelecoes()
						.size(); j++) {

					int media = 0;
					int soma = 0;
					int qntJogadores = copaDAO.listar().get(i).getSelecoes()
							.get(j).getJogadores().size();

					for (int k = 0; k < copaDAO.listar().get(i).getSelecoes()
							.get(j).getJogadores().size(); k++) {
						int idade = ano
								- copaDAO.listar().get(i).getSelecoes().get(j)
										.getJogadores().get(k)
										.getDataNascimento().getYear();
						soma = soma + idade;
					}

					media = soma / qntJogadores;
					String texto = new String(copaDAO.listar().get(i)
							.getSelecoes().get(j).getPais().getNome()
							+ ": " + media + " anos.");
					lista.add(texto);
				}

			}
		}

		return lista;
	}

	// UserStory#32
	public List<String> consultarFinais() {

		copaDAO = new CopaDAOHibernate();
		List<Copa> copa = copaDAO.listar();

		List<Integer> jogo_final = null; // copa.size() 1;
		List<Jogo> jogo = null;

		for (int i = 0; i < copa.size(); i++) {

			jogo = copa.get(i).getJogos();
			jogo_final.add(jogo.size());

		}

		String selecaoA = null;
		String selecaoB = null;

		int golsSelecaoA = 0;
		int golsSelecaoB = 0;

		String final_copa = null;

		List<String> lista = null;

		for (int i = 0; i < copa.size(); i++) {

			selecaoA = copa.get(i).getJogos().get(jogo_final.get(i))
					.getSelecaoA().getPais().getNome();
			selecaoB = copa.get(i).getJogos().get(jogo_final.get(i))
					.getSelecaoB().getPais().getNome();

			golsSelecaoA = copa.get(i).getJogos().get(jogo_final.get(i))
					.getSelecaoA().getGols().size();
			golsSelecaoB = copa.get(i).getJogos().get(jogo_final.get(i))
					.getSelecaoB().getGols().size();

			final_copa = "Final: " + selecaoA + " x " + selecaoB
					+ "   Placar: " + golsSelecaoA + " x " + golsSelecaoB;

			lista.add(final_copa);

		}

		return lista;

	}

	// UserStory#33
	public List<String> consultarTecnicosCampeoes() {

		// List<Tecnico> lista = null;
		String tecnicoCampeao = null;
		List<String> lista = null;

		selecaoDAO = new SelecaoDAOHibernate();
		List<Selecao> selecao = selecaoDAO.listar();

		for (int i = 0; i < selecao.size(); i++) {

			if (selecao.get(i).getPosicao() == 1) {

				tecnicoCampeao = new String(selecao.get(i).getTecnico()
						.getNome());
				lista.add(tecnicoCampeao);

			}

		}

		return lista;
	}

	// UserStory#34
	@SuppressWarnings("null")
	public List<String> consultarGolsContra() {

		List<String> lista = null;
		List<Gol> golsContra = null;
		copaDAO = new CopaDAOHibernate();

		// Coloca todos os gols contra de todas as copas em uma lista
		for (int i = 0; i < copaDAO.listar().size(); i++) {
			for (int j = 0; j < copaDAO.listar().get(i).getJogos().size(); j++) {
				for (int k = 0; k < copaDAO.listar().get(i).getJogos().get(j)
						.getGols().size(); k++) {
					if (copaDAO.listar().get(i).getJogos().get(j).getGols()
							.get(k).getFoiContra()) {
						golsContra.add(copaDAO.listar().get(i).getJogos()
								.get(j).getGols().get(k));
					}
				}
			}
		}

		// Monta a lista informando edicao, jogador e tempo
		for (int i = 0; i < golsContra.size(); i++) {
			String edicao = new String(golsContra.get(i).getJogo().getCopa()
					.getPais().getNome()
					+ " "
					+ golsContra.get(i).getJogo().getCopa().getAno().toString());
			String jogador = new String(golsContra.get(i).getJogador()
					.getNome());
			String tempo = new String(golsContra.get(i).getTempo().toString());

			lista.add(edicao + ", " + jogador + ", " + tempo);
		}

		return lista;
	}

	// UserStory#35
	public List<String> consultarPaisesSedeCampeao() {
		// Listar as edicoes

		List<String> lista = null;
		copaDAO = new CopaDAOHibernate();
		selecaoDAO = new SelecaoDAOHibernate();

		// Varre a lista de copas...
		for (int i = 0; i < copaDAO.listar().size(); i++) {
			// Varre a lista de selecoes da copa...
			for (int j = 0; j < copaDAO.listar().get(i).getSelecoes().size(); j++) {
				// Pegar o campeao da copa... (o que ficou em primeiro lugar)
				if ((copaDAO.listar().get(i).getSelecoes().get(j).getPosicao() == 1)) {
					// E compara se o id do pais sede � o mesmo id do pais da
					// selecao que ficou em primeiro
					if (copaDAO.listar().get(i).getPais().getId() == copaDAO
							.listar().get(i).getSelecoes().get(j).getPais()
							.getId()) {
						// Se for, � marmelada! =P
						// Adiciona a copa na lista no formato: AAAA (PAIS). Ex:
						// 2014 (BRASIL)
						lista.add(copaDAO.listar().get(i).getAno().toString()
								+ "("
								+ copaDAO.listar().get(i).getPais().getNome()
								+ ")");
					}
				}
			}
		}

		return lista;
	}

	// UserStory#36
	public List<String> consultarPaisesMaisTitulos() {

		List<String> lista = null;
		copaDAO = new CopaDAOHibernate();
		paisDAO = new PaisDAOHibernate();
		// linha 0: pais (id) | linha 1: quantidade de titulos. Cada coluna e um
		// pais
		Long[][] titulos = new Long[2][paisDAO.listar().size()];

		// Adiciona todos os paises cadastrados na matriz, inicializando a
		// quantidade de titulos com zero
		for (int i = 0; i < paisDAO.listar().size(); i++) {
			titulos[0][i] = paisDAO.listar().get(i).getId();
			titulos[1][i] = (long) 0;
		}

		// Varre todas as copas...
		for (int i = 0; i < copaDAO.listar().size(); i++) {
			// Varre todas as selecoes da copa...
			for (int j = 0; j < copaDAO.listar().get(i).getSelecoes().size(); j++) {
				// Pega o campeao da copa...
				if (copaDAO.listar().get(i).getSelecoes().get(j).getPosicao() == 1) {
					// Varre a matriz de titulos...
					for (int k = 0; k < paisDAO.listar().size(); k++) {
						// incrementa a quantidade de titulos na matriz, na
						// posicao referente ao pais em questao
						if (titulos[0][k] == copaDAO.listar().get(i)
								.getSelecoes().get(j).getPais().getId()) {
							titulos[1][k]++;
							break;
						}
					}
				}
			}
		}

		// Agora que temos uma matriz que guarda a quantidade de titulos de cada
		// pais, vamos ordenar ele em ordem decrescente
		for (int i = 0; i < paisDAO.listar().size(); i++) {
			for (int j = i + 1; j < paisDAO.listar().size(); j++) {
				if (titulos[1][i] < titulos[1][j]) {
					long aux = titulos[1][i];
					titulos[1][i] = titulos[1][j];
					titulos[1][j] = aux;
				}
			}
		}

		// Com o vetor ordenado em ordem decrescente, sabemos que as 5 primeiras
		// coluans da matriz guardam os paises mais vitoriosos
		for (int i = 0; i < 5; i++) {
			// Buscamos o nome do pais a partir do seu Id..
			String nome = null;
			for (int j = 0; j < paisDAO.listar().size(); j++) {
				// pego o nome...
				if (titulos[0][i] == paisDAO.listar().get(j).getId()) {
					nome = new String(paisDAO.listar().get(j).getNome());
					break;
				}
			}

			// ...e finalmente adiciono na lista de strings informando o nome e
			// a quantidade de titulos.
			lista.add(nome + ": " + titulos[1][i].intValue() + " titulos."); // Exemplo:
																				// "Brasil: 5 titulos."
		}

		return lista;
	}

	// UserStory#37
	public int consultarQntParticipacoesCopa(Pais pais) {

		int quantidade = 0;

		selecaoDAO = new SelecaoDAOHibernate();
		List<Selecao> selecao = selecaoDAO.listar();

		for (int i = 0; i < selecao.size(); i++) {

			if (selecao.get(i).getPais() == pais) {
				quantidade++;
			}

		}

		return quantidade;

	}

	// UserStory#47 (Substitui a 38 pela 47)
	@SuppressWarnings({ "null", "unused" })
	public List<Pais> listarPaiseMaisParticipouFinal() {

		List<Pais> lista = null;
		Pais paisMaior = null;
		int contMaior = 0; // armazenara a maior qnt de vezes
		copaDAO = new CopaDAOHibernate();
		paisDAO = new PaisDAOHibernate();

		for (int i = 0; i < paisDAO.listar().size(); i++) {
			int qnt = 0; // Vai armazenar a quantidade de finais de
							// paisDAO.listar().get(i)
			// Varre todos as copas...
			for (int j = 0; j < copaDAO.listar().size(); j++) {
				// Varre todos os jogos da copa em questao...
				for (int k = 0; k < copaDAO.listar().get(j).getJogos().size(); k++) {
					// Se o jogo for uma final...
					if (copaDAO.listar().get(j).getJogos().get(k).getFase() == Fase.FINAL) {
						// Verifica se a selecaoA do jogo � do pais em
						// questao...
						if (copaDAO.listar().get(j).getJogos().get(k)
								.getSelecaoA().getPais().getId() == paisDAO
								.listar().get(i).getId()) {
							qnt++;
						}
						// Verifica se a selecaoB do jogo � do pais em
						// questao...
						else if (copaDAO.listar().get(j).getJogos().get(k)
								.getSelecaoB().getPais().getId() == paisDAO
								.listar().get(i).getId()) {
							qnt++;
						}
					}
				}
			}
			// Agora que todas as copas foram verificadas, comparar se a
			// quantidade de finais do paisDAO.listar().get(i) � a maior de
			// todas
			if (qnt > contMaior) {
				paisMaior = paisDAO.listar().get(i);
				if (lista != null) {
					lista = null;
				}
			} else if (qnt == contMaior) {
				// Se n�o existir lista de paises, adiciona se o pais que era o
				// unico campeao e o novo pais na lista
				if (lista == null) {
					lista.add(paisMaior);
					lista.add(paisDAO.listar().get(i));
					paisMaior = null;
				}
				// Se uma lista ja existia, apenas adiciona o novo pais
				else {
					lista.add(paisDAO.listar().get(i));
				}
			}
		}

		// Caso n�o haja uma lista, adiciona o pais vencedor em uma lista e
		// retorna uma lista de tamanho 1
		if (lista == null) {
			lista.add(paisMaior);
			return lista;
		} else {
			return lista;
		}
	}

	// UserStory#39
	public List<String> consultarMaioresVice() {

		List<String> lista = null;
		copaDAO = new CopaDAOHibernate();
		paisDAO = new PaisDAOHibernate();
		int maior = 0;

		// Varre lista de paises...
		for (int i = 0; i < paisDAO.listar().size(); i++) {
			int qntVice = 0; // variavel que armazena a quantidade de vezes que
								// um pais foi vice campeao
			// Varre lista de copas...
			for (int j = 0; j < copaDAO.listar().size(); j++) {
				// Varre lista de selecoes da copa...
				for (int k = 0; k < copaDAO.listar().get(j).getSelecoes()
						.size(); k++) {
					// Verifica se a selecao ficou em segundo lugar...
					if (copaDAO.listar().get(j).getSelecoes().get(k)
							.getPosicao() == 2) {
						// Se a selecao que ficou em vice e do pais em
						// questao...
						if (copaDAO.listar().get(j).getSelecoes().get(k)
								.getPais().getId() == paisDAO.listar().get(i)
								.getId()) {
							qntVice++; // Incrementa contador de vice
						}
					}
				}
			}

			// Agora verificamos se a quantidade de vice do ultimo pais
			// verificado eh a maior de todas (ou igual)
			if (qntVice > maior) {
				if (lista == null) {
					lista.add(paisDAO.listar().get(i).getNome());
				} else {
					lista.clear();
					lista.add(paisDAO.listar().get(i).getNome());
				}
			} else if (qntVice == maior) {
				lista.add(paisDAO.listar().get(i).getNome());
			}
		}

		return lista;
	}

	// UserStory#43 (Substitui a 40 pela 43)
	public List<String> listarJogadoresMaisJogos() {
		// OBS: exibir o jogador que mais jogou em copas (exibe a quantidade)

		List<String> lista = null;
		jogadorDAO = new JogadorDAOHibernate();
		copaDAO = new CopaDAOHibernate();
		int maior = 0; // armazena a maior quantidade de vezes que um jogador
						// jogou

		// Percorre a lista de jogadores cadastrados...
		for (int i = 0; i < jogadorDAO.listar().size(); i++) {
			int qntJogos = 0; // contador de vezes que o jogador
								// jogadorDAO.listar().get(i) jogou

			// Varre a lista de copas...
			for (int j = 0; j < copaDAO.listar().size(); j++) {
				// Varre a lista de jogos da copa...
				for (int k = 0; k < copaDAO.listar().get(j).getJogos().size(); k++) {
					// Varre a escalacao da selecao A...
					for (int a = 0; a < copaDAO.listar().get(j).getJogos()
							.get(k).getEscalacaoA().getJogadores().size(); a++) {
						// Verifica se o jogador foi escalado
						if (jogadorDAO.listar().get(i).getId() == copaDAO
								.listar().get(j).getJogos().get(k)
								.getEscalacaoA().getJogadores().get(a).getId()) {
							qntJogos++;
						}
					}
					// ...da selecao B
					for (int b = 0; b < copaDAO.listar().get(j).getJogos()
							.get(k).getEscalacaoA().getJogadores().size(); b++) {
						// Verifica se o jogador foi escalado
						if (jogadorDAO.listar().get(i).getId() == copaDAO
								.listar().get(j).getJogos().get(k)
								.getEscalacaoB().getJogadores().get(b).getId()) {
							qntJogos++;
						}
					}
				}
			}

			// Comparada a quantidade de jogos dele com a maior registrada
			if (qntJogos > maior) {
				String jogador = new String(jogadorDAO.listar().get(i)
						.getNome()
						+ " - " + qntJogos + " jogos.");
				if (lista == null) {
					lista.add(jogador);
				} else {
					lista.clear();
					lista.add(jogador);
				}
			}

			if (qntJogos == maior) {
				String jogador = new String(jogadorDAO.listar().get(i)
						.getNome()
						+ " - " + qntJogos + " jogos.");
				if (lista == null) {
					lista.add(jogador);
				} else {
					lista.add(jogador);
				}
			}
		}

		return lista;
	}

}