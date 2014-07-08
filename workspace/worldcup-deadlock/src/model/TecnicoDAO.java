package model;

import java.util.List;

public interface TecnicoDAO {
	
	public abstract void adicionar(Tecnico objeto);
	public abstract void atualizar(Tecnico objeto);
	public abstract void remover(Tecnico objeto);
	public abstract void removerTodos();
	public abstract List<Tecnico> listar();
	public abstract Tecnico buscar(Long id);

}
