package model;

import java.util.List;

public interface SubstituicaoDAO {
	
	public abstract void adicionar(Substituicao objeto);
	public abstract void atualizar(Substituicao objeto);
	public abstract void remover(Substituicao objeto);
	public abstract void removerTodos();
	public abstract List<Substituicao> listar();
	public abstract Substituicao buscar(Long id);

}
