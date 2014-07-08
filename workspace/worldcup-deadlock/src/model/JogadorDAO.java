package model;

import java.util.List;

public interface JogadorDAO {
	
	public abstract void adicionar(Jogador objeto);
	public abstract void atualizar(Jogador objeto);
	public abstract void remover(Jogador objeto);
	public abstract void removerTodos();
	public abstract List<Jogador> listar();
	public abstract Jogador buscar(Long id);

}
