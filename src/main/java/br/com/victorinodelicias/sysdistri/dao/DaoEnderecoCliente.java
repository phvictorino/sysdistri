package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import org.hibernate.Criteria;

import br.com.victorinodelicias.sysdistri.entity.EnEnderecoCliente;

public class DaoEnderecoCliente extends GenericDAO<EnEnderecoCliente> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<EnEnderecoCliente> buscarPorIdCliente(Integer codigo) {
		Criteria c = getCriteria();
		c.add(Restrictions.eq("codCliente", codigo));
		return c.list();
	}

}
