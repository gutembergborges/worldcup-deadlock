package model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

public class JogadorDAOHibernateTest {

	@Test
	public void testAdicionar() {
		JogadorDAOHibernate jogadorDAO = new JogadorDAOHibernate();
		assertEquals(0, jogadorDAO.listar().size());
		Jogador jogador = new Jogador();
		Date data = new Date();
		Integer numero = 15;
		data.setYear(1980);
		data.setMonth(05);
		data.setDate(18);
		jogador.setData_nascimento(data);
		jogador.setNome("Reginaldo");
		jogador.setNumero(numero);
		jogadorDAO.adicionar(jogador);
		assertEquals(1, jogadorDAO.listar().size());
		Jogador jogador2 = new Jogador();
		Date data2 = new Date();
		Integer numero2 = 7;
		data2.setYear(1995);
		data2.setMonth(01);
		data2.setDate(23);
		jogador2.setData_nascimento(data2);
		jogador2.setNome("Florisvaldo");
		jogador2.setNumero(numero2);
		jogadorDAO.adicionar(jogador2);
		assertEquals(2, jogadorDAO.listar().size());
	}

	@Test
	public void testAtualizar() {
		JogadorDAOHibernate jogadorDAO = new JogadorDAOHibernate();
		Long id = (long) 2;
		Jogador jogador = jogadorDAO.buscar(id);
		Date data = new Date();
		data.setYear(100);
		data.setMonth(10);
		data.setDate(22);
		jogador.setData_nascimento(data);
		jogador.setNome("Jubenilton");
		jogador.setNumero(4);
		jogadorDAO.atualizar(jogador);
		assertEquals(22, jogadorDAO.buscar(id).getDataNascimento().getDate());
		assertEquals("Jubenilton", jogadorDAO.buscar(id).getNome());
	}

	@Test
	public void testRemover() {
		JogadorDAOHibernate jogadorDAO = new JogadorDAOHibernate();
		Long id = (long) 2;
		Jogador jogador = jogadorDAO.buscar(id);
		jogadorDAO.remover(jogador);
		assertEquals(1, jogadorDAO.listar().size());
	}

	@Test
	public void testRemoverTodos() {
		JogadorDAOHibernate jogadorDAO = new JogadorDAOHibernate();
		jogadorDAO.removerTodos();
		assertEquals(0, jogadorDAO.listar().size());
	}

	@Test
	public void testListar() {
		JogadorDAOHibernate jogadorDAO = new JogadorDAOHibernate();
		List<Jogador> jogador = jogadorDAO.listar();
		assertEquals(2, jogador.size());
	}

	@Test
	public void testBuscar() {
		JogadorDAOHibernate jogadorDAO = new JogadorDAOHibernate();
		Long id = (long) 7;
		Jogador jogador = jogadorDAO.buscar(id);
		Integer inteiro = 15;
		assertEquals(inteiro, jogador.getNumero());
		assertEquals("Reginaldo", jogador.getNome());
	}

}
