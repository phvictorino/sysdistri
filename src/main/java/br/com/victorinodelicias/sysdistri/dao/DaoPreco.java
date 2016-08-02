package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;

import br.com.victorinodelicias.sysdistri.entity.EnPreco;

public class DaoPreco extends GenericDAO<EnPreco> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<EnPreco> listarTodosSemLazyVendedor() {
		Criteria c = getCriteria();
		c.setFetchMode("vendedor", FetchMode.JOIN);
		return c.list();
	}

}
