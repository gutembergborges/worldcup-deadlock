package model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SelecaoDAOHibernateTest {

	@Test
	public void testAdicionar() {
		Pais pais = new Pais();
		pais.setNome("Brasil");
		pais.setContinente("America do Sul");
		
		SelecaoDAOHibernate selecaoDAO = new SelecaoDAOHibernate();
		assertEquals(0, selecaoDAO.listar().size());
		Selecao selecao = new Selecao();
		
		selecao.setPais(pais);
		
		Integer ano = 2006;
		selecao.setAno(ano);
		Integer posicao = 1;
		selecao.setPosicao(posicao);
		Integer grupo = 8;
		selecao.setGrupo(grupo);
		selecaoDAO.adicionar(selecao);
		assertEquals(1, selecaoDAO.listar().size());
		
		Pais pais2 = new Pais();
		pais2.setNome("Alemanha");
		pais2.setContinente("Europa");
		
		Selecao selecao2 = new Selecao();
		
		selecao2.setPais(pais2);
		
		Integer ano2 = 2006;
		selecao2.setAno(ano2);
		Integer posicao2 = 2;
		selecao2.setPosicao(posicao2);
		Integer grupo2 = 5;
		selecao2.setGrupo(grupo2);
		selecaoDAO.adicionar(selecao2);
		assertEquals(4, selecaoDAO.listar().size());
	}

	@Test
	public void testAtualizar() {
		/*SelecaoDAOHibernate selecaoDAO = new SelecaoDAOHibernate();
		Selecao selecao = selecaoDAO.buscar("Brasil");
		assert*/
	}

	@Test
	public void testRemover() {
		/*SelecaoDAOHibernate selecaoDAO = new SelecaoDAOHibernate();
		Selecao selecao = selecaoDAO.buscar(nome);*/
	}

	@Test
	public void testRemoverTodos() {
		SelecaoDAOHibernate selecaoDAO = new SelecaoDAOHibernate();
		selecaoDAO.removerTodos();
		assertEquals(0, selecaoDAO.listar().size());;
	}

	@Test
	public void testListar() {
		SelecaoDAOHibernate selecaoDAO = new SelecaoDAOHibernate();
		List<Selecao> selecao = selecaoDAO.listar();
		assertEquals(4, selecao.size());
	}

	@Test
	public void testBuscar() {
		/*SelecaoDAOHibernate selecaoDAO = new SelecaoDAOHibernate();
		Selecao selecao = selecaoDAO.buscar("Brasil");
		Integer i = 8;
		assertEquals(i, selecao.getGrupo());*/
	}

}
