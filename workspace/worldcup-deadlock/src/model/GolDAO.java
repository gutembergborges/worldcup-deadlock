package model;

import java.util.List;

public interface GolDAO {
	
	public abstract void adicionar(Gol objeto);
	public abstract void atualizar(Gol objeto);
	public abstract void remover(Gol objeto);
	public abstract void removerTodos();
	public abstract List<Gol> listar();
	public abstract Gol buscar(Long id);

}
