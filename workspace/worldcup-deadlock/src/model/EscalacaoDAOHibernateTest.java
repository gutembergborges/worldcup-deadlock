package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class EscalacaoDAOHibernateTest {

	@Test
	public void testAdicionar() {
		EscalacaoDAOHibernate escalacaoDAO = new EscalacaoDAOHibernate();
		assertEquals(0, escalacaoDAO.listar().size());
		Escalacao escalacao = new Escalacao();
		escalacao.setId((long) 1);
		escalacaoDAO.adicionar(escalacao);
		assertEquals(1, escalacaoDAO.listar().size());
		Escalacao escalacao2 = new Escalacao();
		escalacao2.setId((long) 2);
		escalacaoDAO.adicionar(escalacao2);
		assertEquals(2, escalacaoDAO.listar().size());
	}

	@Test
	
	public void testAtualizar() {
		EscalacaoDAOHibernate escalacaoDAO = new EscalacaoDAOHibernate();
		Escalacao escalacao = escalacaoDAO.buscar((long) 1);
		escalacao.setId((long) 2);
		escalacaoDAO.atualizar(escalacao);
		Long id = (long) 3;
		assertEquals(id, escalacaoDAO.buscar((long) 3).getId());
	}

	@Test
	public void testRemover() {
		EscalacaoDAOHibernate escalacaoDAO = new EscalacaoDAOHibernate();
		Escalacao escalacao = escalacaoDAO.buscar((long) 1);
		escalacaoDAO.remover(escalacao);
		assertEquals(1, escalacaoDAO.listar().size());
	}

	@Test
	public void testRemoverTodos() {
		EscalacaoDAOHibernate escalacaoDAO = new EscalacaoDAOHibernate();
		escalacaoDAO.removerTodos();
		assertEquals(0, escalacaoDAO.listar().size());
	}

	@Test
	public void testListar() {
		EscalacaoDAOHibernate escalacaoDAO = new EscalacaoDAOHibernate();
		List<Escalacao> escalacao = escalacaoDAO.listar();
		assertEquals(2, escalacao.size());
	}

	@Test
	public void testBuscar() {
		EscalacaoDAOHibernate escalacaoDAO = new EscalacaoDAOHibernate();
		Escalacao escalacao = escalacaoDAO.buscar((long) 2);
		Long id = (long) 2;
		assertEquals(id, escalacao.getId());
	}

}