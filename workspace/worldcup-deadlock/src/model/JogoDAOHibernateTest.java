package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class JogoDAOHibernateTest {
	
	@Test
	public void testAdicionar() {
		JogoDAOHibernate jogoDAO = new JogoDAOHibernate();
		assertEquals(0, jogoDAO.listar().size());
		Jogo jogo = new Jogo();
		jogo.setId((long) 1);
		jogoDAO.adicionar(jogo);
		assertEquals(1, jogoDAO.listar().size());
		Jogo jogo2 = new Jogo();
		jogo2.setId((long) 2);
		jogoDAO.adicionar(jogo2);
		assertEquals(2, jogoDAO.listar().size());
	}

	@Test
	// N�O FUNCIONA!!!!! mas deveria "/
	public void testAtualizar() {
		JogoDAOHibernate jogoDAO = new JogoDAOHibernate();
		Jogo jogo = jogoDAO.buscar((long) 1);
		jogo.setId((long) 2);
		jogoDAO.atualizar(jogo);
		Long id = (long) 3;
		assertEquals(id, jogoDAO.buscar((long) 3).getId());
	}

	@Test
	public void testRemover() {
		JogoDAOHibernate jogoDAO = new JogoDAOHibernate();
		Jogo jogo = jogoDAO.buscar((long) 1);
		jogoDAO.remover(jogo);
		assertEquals(1, jogoDAO.listar().size());
	}

	@Test
	public void testRemoverTodos() {
		JogoDAOHibernate jogoDAO = new JogoDAOHibernate();
		jogoDAO.removerTodos();
		assertEquals(0, jogoDAO.listar().size());
	}

	@Test
	public void testListar() {
		JogoDAOHibernate jogoDAO = new JogoDAOHibernate();
		List<Jogo> jogo = jogoDAO.listar();
		assertEquals(2, jogo.size());
	}

	@Test
	public void testBuscar() {
		JogoDAOHibernate jogoDAO = new JogoDAOHibernate();
		Jogo jogo = jogoDAO.buscar((long) 2);
		Long id = (long) 2;
		assertEquals(id, jogo.getId());
	}

}
