package model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class SelecaoDAOHibernate implements SelecaoDAO{
	
	Session sessao = null;
	Transaction transacao = null;

	@Override
	public void adicionar(Selecao objeto) {
		
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
	public void atualizar(Selecao objeto) {
		
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
	public void remover(Selecao objeto) {
		
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
			Query consulta = sessao.createQuery("delete from Selecao");
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
	public List<Selecao> listar() {
		
		List<Selecao> resultado = null;
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();
			Query consulta = sessao.createQuery("from Selecao");
			transacao = sessao.beginTransaction();
			resultado = (List<Selecao>) consulta.list();
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
	public Selecao buscar(String nome) {
		
		Selecao objeto = null;
		
		try {
			
			HibernateUtil.getInstance();
			sessao = HibernateUtil.getSessionFactory().openSession();

			Query consulta = sessao.createQuery("from Selecao where nome = :parametro");
			consulta.setString("parametro", nome);

			transacao = sessao.beginTransaction();
			objeto = (Selecao) consulta.uniqueResult();
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
