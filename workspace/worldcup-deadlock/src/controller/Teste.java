package controller;

import model.Pais;
import model.PaisDAOHibernate;

public class Teste {

	public static void main(String[] args) {
		
		Pais pais = new Pais();
		pais.setNome("Brasil");
		pais.setContinente("America do Sul");
		
		PaisDAOHibernate paisHibernate = new PaisDAOHibernate();
		paisHibernate.adicionar(pais);
		
	}

}
