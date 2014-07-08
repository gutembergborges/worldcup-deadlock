package model;

import java.util.List;

public interface CopaDAO {
	
	public abstract void adicionar(Copa objeto);
	public abstract void atualizar(Copa objeto);
	public abstract void remover(Copa objeto);
	public abstract void removerTodos();
	public abstract List<Copa> listar();
	public abstract Copa buscar(int ano);

}
