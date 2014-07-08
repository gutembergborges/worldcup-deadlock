package model;

import java.util.List;

public interface EscalacaoDAO {
	
	public abstract void adicionar(Escalacao objeto);
	public abstract void atualizar(Escalacao objeto);
	public abstract void remover(Escalacao objeto);
	public abstract void removerTodos();
	public abstract List<Escalacao> listar();
	public abstract Escalacao buscar(Long id);

}
