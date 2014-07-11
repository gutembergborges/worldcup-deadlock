package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class SubstituicaoDAOHibernate implements SubstituicaoDAO{
	
	Session sessao = null;
	Transaction transacao = null;

	@Override
	public void adicionar(Substituicao objeto) {
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(objeto);
			transacao.commit();
			
		} catch (HibernateException e) {
			
			System.err.println("N�o foi possivel inserir o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar opera��o de inser��o: " + e.getMessage());	
				
			}
		}
		
	}

	@Override
	public void atualizar(Substituicao objeto) {
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();		
			transacao = sessao.beginTransaction();
			sessao.update(objeto);
			transacao.commit();
			
		} catch (HibernateException e) {
			
			System.err.println("N�o foi possivel atualizar o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar opera��o de atualiza��o: " + e.getMessage());	
				
			}
		}
		
	}

	@Override
	public void remover(Substituicao objeto) {
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.delete(objeto);
			transacao.commit();
				
		} catch (HibernateException e) {
			
			System.err.println("N�o foi possivel excluir o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar opera��o de exclus�o: " + e.getMessage());	
				
			}
		}
		
	}

	@Override
	public void removerTodos() {
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			Query consulta = sessao.createQuery("delete from Substituicao");
			transacao = sessao.beginTransaction();
			consulta.executeUpdate();
			transacao.commit();
			
		} catch (HibernateException e) {
			
			System.err.println("N�o foi possivel excluir os objetos: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar opera��o de exclus�o: " + e.getMessage());	
				
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Substituicao> listar() {
		
		List<Substituicao> resultado = null;
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			Query consulta = sessao.createQuery("from Substituicao");
			transacao = sessao.beginTransaction();
			resultado = consulta.list();
			transacao.commit();
			return resultado;
			
		} catch (HibernateException e) {
			
			System.err.println("N�o foi possivel listar os objetos: " + e.getMessage());
			throw new HibernateException(e);
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar opera��o de listagem: " + e.getMessage());	
				
			}
		}
	}

	@Override
	public Substituicao buscar(Long id) {
		
		Substituicao objeto = null;
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Substituicao where id = :parametro");
			consulta.setLong("parametro", id);

			transacao = sessao.beginTransaction();
			objeto = (Substituicao) consulta.uniqueResult();
			transacao.commit();
			return objeto;
			
		} catch (HibernateException e) {
			
			System.err.println("N�o foi possivel buscar o objeto: " + e.getMessage());
			
		} finally {
			try {
				
				sessao.close();
				
			} catch (Throwable e) {
				
				System.err.println("Erro ao fechar opera��o de busca: " + e.getMessage());				
			}
		}
		
		return objeto;
	}

}
