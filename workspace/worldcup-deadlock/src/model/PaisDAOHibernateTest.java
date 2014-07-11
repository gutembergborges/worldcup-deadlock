package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PaisDAOHibernateTest {
	
	@Test
	public void testAdicionar() {
		PaisDAOHibernate paisDAO = new PaisDAOHibernate();
		assertEquals(0, paisDAO.listar().size());
		Pais pais = new Pais();
		pais.setId((long) 1);
		pais.setNome("Brasil");
		paisDAO.adicionar(pais);
		assertEquals(1, paisDAO.listar().size());
		Pais pais2 = new Pais();
		pais2.setId((long) 2);
		pais.setNome("Alemanha");
		paisDAO.adicionar(pais2);
		assertEquals(2, paisDAO.listar().size());
	}

	@Test
	// N�O FUNCIONA!!!!! mas deveria "/
	public void testAtualizar() {
		PaisDAOHibernate paisDAO = new PaisDAOHibernate();
		Pais pais = paisDAO.buscar("Brasil");
		pais.setId((long) 2);
		paisDAO.atualizar(pais);
		String paisNome = "Holanda";
		assertEquals(paisNome, paisDAO.buscar("Holanda").getNome());
	}

	@Test
	public void testRemover() {
		PaisDAOHibernate paisDAO = new PaisDAOHibernate();
		Pais pais = paisDAO.buscar("Brasil");
		paisDAO.remover(pais);
		assertEquals(1, paisDAO.listar().size());
	}

	@Test
	public void testRemoverTodos() {
		PaisDAOHibernate paisDAO = new PaisDAOHibernate();
		paisDAO.removerTodos();
		assertEquals(0, paisDAO.listar().size());
	}

	@Test
	public void testListar() {
		PaisDAOHibernate paisDAO = new PaisDAOHibernate();
		List<Pais> pais = paisDAO.listar();
		assertEquals(2, pais.size());
	}

	@Test
	public void testBuscar() {
		PaisDAOHibernate paisDAO = new PaisDAOHibernate();
		Pais pais = paisDAO.buscar("Alemanha");
		Long id = (long) 2;
		assertEquals(id, pais.getId());
	}

}
