package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class CopaDAOHibernateTest {

	@Test
	public void testAdicionar() {
		CopaDAOHibernate copaDAO = new CopaDAOHibernate();
		assertEquals(0, copaDAO.listar().size());
		Copa copa = new Copa();
		copa.setAno(1990);
		copaDAO.adicionar(copa);
		assertEquals(1, copaDAO.listar().size());
		Copa copa2 = new Copa();
		copa2.setAno(2002);
		copaDAO.adicionar(copa2);
		assertEquals(2, copaDAO.listar().size());
	}

	@Test
	// N�O FUNCIONA!!!!! mas deveria "/
	public void testAtualizar() {
		CopaDAOHibernate copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(1990);
		copa.setAno(2010);
		copaDAO.atualizar(copa);
		Integer ano = 2010;
		assertEquals(ano, copaDAO.buscar(2010).getAno());
	}

	@Test
	public void testRemover() {
		CopaDAOHibernate copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(1990);
		copaDAO.remover(copa);
		assertEquals(1, copaDAO.listar().size());
	}

	@Test
	public void testRemoverTodos() {
		CopaDAOHibernate copaDAO = new CopaDAOHibernate();
		copaDAO.removerTodos();
		assertEquals(0, copaDAO.listar().size());
	}

	@Test
	public void testListar() {
		CopaDAOHibernate copaDAO = new CopaDAOHibernate();
		List<Copa> copa = copaDAO.listar();
		assertEquals(2, copa.size());
	}

	@Test
	public void testBuscar() {
		CopaDAOHibernate copaDAO = new CopaDAOHibernate();
		Copa copa = copaDAO.buscar(2002);
		Integer ano = 2002;
		assertEquals(ano, copa.getAno());
	}

}
