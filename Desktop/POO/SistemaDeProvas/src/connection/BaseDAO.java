package connection;

import java.util.ArrayList;

public interface BaseDAO<E> {
	public E buscar(E objeto);
	public void alterar(E objeto);
	public void remover(E objeto);
	public ArrayList<E> listar();
	public void inserir(E objeto);
}

