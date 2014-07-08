package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null;
	
	private static HibernateUtil instance = null;
	
	private HibernateUtil() {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			HibernateUtil.sessionFactory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			System.out.println("Criacao do objeto SessionFactory falhou: " + e);
			throw new ExceptionInInitializerError(e);
		}		
	}
	
	public static HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void zerarSistema() {
		instance = null;
		
	}

}
