package br.com.victorinodelicias.sysdistri.bussiness;

import java.io.Serializable;
import java.util.List;

import br.com.victorinodelicias.sysdistri.dao.GenericDAO;

public class GenericBO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected GenericDAO<T> dao;

	public List<T> listarTodos() {
		return dao.listarTodos();
	}

	public T salvaOuAtualiza(T obj) {
		return dao.salvaOuAtualiza(obj);
	}

	public void persistir(T obj) {
		dao.persistir(obj);
	}

	public void remover(T obj) {
		dao.remover(obj);
	}	

	public T buscarPorId(Integer id) {
		return dao.buscarPorId(id);
	}

}
