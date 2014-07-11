package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TecnicoDAOHibernateTest {
	
	@Test
	public void testAdicionar() {
		TecnicoDAOHibernate tecnicoDAO = new TecnicoDAOHibernate();
		assertEquals(0, tecnicoDAO.listar().size());
		Tecnico tecnico = new Tecnico();
		tecnico.setId((long) 1);
		tecnico.setNome("Luis Felipe Scolari");
		tecnicoDAO.adicionar(tecnico);
		assertEquals(1, tecnicoDAO.listar().size());
		Tecnico tecnico2 = new Tecnico();
		tecnico2.setId((long) 2);
		tecnico.setNome("Joachim Low");
		tecnicoDAO.adicionar(tecnico2);
		assertEquals(2, tecnicoDAO.listar().size());
	}

	@Test
	// N�O FUNCIONA!!!!! mas deveria "/
	public void testAtualizar() {
		TecnicoDAOHibernate tecnicoDAO = new TecnicoDAOHibernate();
		Tecnico tecnico = tecnicoDAO.buscar("Luis Felipe Scolari");
		tecnico.setId((long) 2);
		tecnicoDAO.atualizar(tecnico);
		String tecnicoNome = "Fabio Capello";
		assertEquals(tecnicoNome, tecnicoDAO.buscar("Fabio Capello").getNome());
	}

	@Test
	public void testRemover() {
		TecnicoDAOHibernate tecnicoDAO = new TecnicoDAOHibernate();
		Tecnico tecnico = tecnicoDAO.buscar("Luis Felipe Scolari");
		tecnicoDAO.remover(tecnico);
		assertEquals(1, tecnicoDAO.listar().size());
	}

	@Test
	public void testRemoverTodos() {
		TecnicoDAOHibernate tecnicoDAO = new TecnicoDAOHibernate();
		tecnicoDAO.removerTodos();
		assertEquals(0, tecnicoDAO.listar().size());
	}

	@Test
	public void testListar() {
		TecnicoDAOHibernate tecnicoDAO = new TecnicoDAOHibernate();
		List<Tecnico> tecnico = tecnicoDAO.listar();
		assertEquals(2, tecnico.size());
	}

	@Test
	public void testBuscar() {
		TecnicoDAOHibernate tecnicoDAO = new TecnicoDAOHibernate();
		Tecnico tecnico = tecnicoDAO.buscar("Joachim Low");
		Long id = (long) 2;
		assertEquals(id, tecnico.getId());
	}

}
