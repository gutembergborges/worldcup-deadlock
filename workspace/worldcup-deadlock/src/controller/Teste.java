package controller;
import java.util.List;
import model.*;

public class Teste {

	public static void main(String[] args) {
		
		Cadastrar cadastro = new Cadastrar();
		cadastro.cadastrarPais("Brasil", "America do Sul");
		//Teste cadastro de país
		//cadastro.cadastrarPais("Holanda", "Europa");
		//cadastro.cadastrarPais("Japão", "Ásia");
		
		//Teste consulta países cadastrados
		//Consultar consulta = new Consultar();
		//List<Pais> lista = consulta.listarTodosPaises();
	//	System.out.println("Listando países cadastrados (" + lista.size() + "): ");
	//	for(int i = 0; i < lista.size(); i++){
	//		System.out.println(lista.get(i).getNome());
	//	}
		
		
	}

}
