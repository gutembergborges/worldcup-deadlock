package controller;
import java.util.List;
import model.*;

public class Teste {

	public static void main(String[] args) {
		
		Cadastrar cadastro = new Cadastrar();
		cadastro.cadastrarPais("Brasil", "America do Sul");
		//Teste cadastro de pa�s
		//cadastro.cadastrarPais("Holanda", "Europa");
		//cadastro.cadastrarPais("Jap�o", "�sia");
		
		//Teste consulta pa�ses cadastrados
		//Consultar consulta = new Consultar();
		//List<Pais> lista = consulta.listarTodosPaises();
	//	System.out.println("Listando pa�ses cadastrados (" + lista.size() + "): ");
	//	for(int i = 0; i < lista.size(); i++){
	//		System.out.println(lista.get(i).getNome());
	//	}
		
		
	}

}
