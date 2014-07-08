package model;

import java.util.List;

public interface SelecaoDAO {
	
	public abstract void adicionar(Selecao objeto);
	public abstract void atualizar(Selecao objeto);
	public abstract void remover(Selecao objeto);
	public abstract void removerTodos();
	public abstract List<Selecao> listar();
	public abstract Selecao buscar(String nome);

}
