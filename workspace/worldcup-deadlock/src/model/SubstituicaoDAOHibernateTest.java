package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SubstituicaoDAOHibernateTest {
	
	@Test
	public void testAdicionar() {
		SubstituicaoDAOHibernate substituicaoDAO = new SubstituicaoDAOHibernate();
		assertEquals(0, substituicaoDAO.listar().size());
		Substituicao substituicao = new Substituicao();
		substituicao.setId((long) 1);
		substituicaoDAO.adicionar(substituicao);
		assertEquals(1, substituicaoDAO.listar().size());
		Substituicao substituicao2 = new Substituicao();
		substituicao2.setId((long) 2);
		substituicaoDAO.adicionar(substituicao2);
		assertEquals(2, substituicaoDAO.listar().size());
	}

	@Test
	// N�O FUNCIONA!!!!! mas deveria "/
	public void testAtualizar() {
		SubstituicaoDAOHibernate substituicaoDAO = new SubstituicaoDAOHibernate();
		Substituicao substituicao = substituicaoDAO.buscar((long) 1);
		substituicao.setId((long) 2);
		substituicaoDAO.atualizar(substituicao);
		Long id = (long) 3;
		assertEquals(id, substituicaoDAO.buscar((long) 3).getId());
	}

	@Test
	public void testRemover() {
		SubstituicaoDAOHibernate substituicaoDAO = new SubstituicaoDAOHibernate();
		Substituicao substituicao = substituicaoDAO.buscar((long) 1);
		substituicaoDAO.remover(substituicao);
		assertEquals(1, substituicaoDAO.listar().size());
	}

	@Test
	public void testRemoverTodos() {
		SubstituicaoDAOHibernate substituicaoDAO = new SubstituicaoDAOHibernate();
		substituicaoDAO.removerTodos();
		assertEquals(0, substituicaoDAO.listar().size());
	}

	@Test
	public void testListar() {
		SubstituicaoDAOHibernate substituicaoDAO = new SubstituicaoDAOHibernate();
		List<Substituicao> substituicao = substituicaoDAO.listar();
		assertEquals(2, substituicao.size());
	}

	@Test
	public void testBuscar() {
		SubstituicaoDAOHibernate substituicaoDAO = new SubstituicaoDAOHibernate();
		Substituicao substituicao = substituicaoDAO.buscar((long) 2);
		Long id = (long) 2;
		assertEquals(id, substituicao.getId());
	}

}