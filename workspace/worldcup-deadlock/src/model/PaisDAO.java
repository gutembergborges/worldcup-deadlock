package model;

import java.util.List;

public interface PaisDAO {
	
	public abstract void adicionar(Pais objeto);
	public abstract void atualizar(Pais objeto);
	public abstract void remover(Pais objeto);
	public abstract void removerTodos();
	public abstract List<Pais> listar();
	public abstract Pais buscar(String nome);

}
