package model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

public class GolDAOHibernateTest {

	@Test
	public void testAdicionar() {
		GolDAOHibernate golDAO = new GolDAOHibernate();
		assertEquals(0, golDAO.listar().size());
		Gol gol = new Gol();
		gol.setFoiContra(false);
		Date tempo = new Date();
		tempo.setHours(00);
		tempo.setMinutes(25);
		tempo.setSeconds(04);
		gol.setTempo(tempo);
		golDAO.adicionar(gol);
		assertEquals(1, golDAO.listar().size());
		Gol gol2 = new Gol();
		gol2.setFoiContra(false);
		tempo.setMinutes(03);
		tempo.setSeconds(56);
		gol2.setTempo(tempo);
		golDAO.adicionar(gol2);
		assertEquals(2, golDAO.listar().size());
	}

	@Test
	public void testAtualizar() {
		GolDAOHibernate golDAO = new GolDAOHibernate();
		Gol gol = new Gol();
		Long id = (long) 2;
		gol = golDAO.buscar(id);
		Date tempo = new Date();
		tempo.setHours(00);
		tempo.setMinutes(42);
		tempo.setSeconds(27);
		gol.setTempo(tempo);
		golDAO.atualizar(gol);
		assertEquals(27, golDAO.buscar(id).getTempo().getSeconds());
	}

	@Test
	public void testRemover() {
		GolDAOHibernate golDAO = new GolDAOHibernate();
		Long id = (long) 1;
		Gol gol = golDAO.buscar(id);
		golDAO.remover(gol);
		assertEquals(1, golDAO.listar().size());
	}

	@Test 
	public void testRemoverTodos() {
		GolDAOHibernate golDAO = new GolDAOHibernate();
		golDAO.removerTodos();
		assertEquals(0, golDAO.listar().size());
	}

	@Test
	public void testListar() {
		GolDAOHibernate golDAO = new GolDAOHibernate();
		List<Gol> gol = golDAO.listar();
		assertEquals(2, gol.size());
	}

	@Test
	public void testBuscar() {
		GolDAOHibernate golDAO = new GolDAOHibernate();
		Long id = (long) 14;
		Gol gol = golDAO.buscar(id);
		assertEquals(25, gol.getTempo().getMinutes());
	}

}
