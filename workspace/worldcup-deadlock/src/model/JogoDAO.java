package model;
import java.util.List;

public interface JogoDAO {
	
	public abstract void adicionar(Jogo objeto);
	public abstract void atualizar(Jogo objeto);
	public abstract void remover(Jogo objeto);
	public abstract void removerTodos();
	public abstract List<Jogo> listar();
	public abstract Jogo buscar(Long id);

}
