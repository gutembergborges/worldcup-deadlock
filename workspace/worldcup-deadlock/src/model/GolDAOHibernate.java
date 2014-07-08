package model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GolDAOHibernate implements GolDAO {
	
	Session sessao = null;
	Transaction transacao = null;

	@Override
	public void adicionar(Gol objeto) {
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(objeto);
			transacao.commit();
			
		} catch (HibernateException e) {
			
			System.err.println("Não foi possivel inserir o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar operação de inserção: " + e.getMessage());	
				
			}
		}
		
	}

	@Override
	public void atualizar(Gol objeto) {
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();		
			transacao = sessao.beginTransaction();
			sessao.update(objeto);
			transacao.commit();
			
		} catch (HibernateException e) {
			
			System.err.println("Não foi possivel atualizar o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar operação de atualização: " + e.getMessage());	
				
			}
		}
		
	}

	@Override
	public void remover(Gol objeto) {

		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(objeto);
			transacao.commit();
				
		} catch (HibernateException e) {
			
			System.err.println("Não foi possivel excluir o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar operação de exclusão: " + e.getMessage());	
				
			}
		}
		
	}

	@Override
	public void removerTodos() {

		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			Query consulta = sessao.createQuery("delete from Escalacao");
			transacao = sessao.beginTransaction();
			consulta.executeUpdate();
			transacao.commit();
			
		} catch (HibernateException e) {
			
			System.err.println("Não foi possivel excluir os objetos: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar operação de exclusão: " + e.getMessage());	
				
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gol> listar() {

		List<Gol> resultado = null;
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			Query consulta = sessao.createQuery("from Gol");
			transacao = sessao.beginTransaction();
			resultado = (List<Gol>) consulta.list();
			transacao.commit();
			return resultado;
			
		} catch (HibernateException e) {
			
			System.err.println("Não foi possivel listar os objetos: " + e.getMessage());
			throw new HibernateException(e);
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar operação de listagem: " + e.getMessage());	
				
			}
		}
		
	}

	@Override
	public Gol buscar(Long id) {
		
		Gol objeto = null;
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Gol where id = :parametro");
			consulta.setLong("parametro", id);

			transacao = sessao.beginTransaction();
			objeto = (Gol) consulta.uniqueResult();
			transacao.commit();
			return objeto;
			
		} catch (HibernateException e) {
			
			System.err.println("Não foi possivel buscar o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar operação de busca: " + e.getMessage());				
			}
		}
		
		return objeto;
	}

}
