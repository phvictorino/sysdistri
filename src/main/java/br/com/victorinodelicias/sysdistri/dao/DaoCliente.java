package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import br.com.victorinodelicias.dto.DtoCliente;
import br.com.victorinodelicias.sysdistri.entity.EnCliente;

public class DaoCliente extends GenericDAO<EnCliente> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<DtoCliente> buscarTodosPorDto(Integer codVendedor) {

		String hql = "SELECT new br.com.victorinodelicias.dto.DtoCliente (";
		hql = hql + " c.codigo, c.nome, c.telefone, v.nome) ";
		hql = hql + " FROM EnCliente c ";
		hql = hql + " LEFT OUTER JOIN c.vendedor v ";

		if (codVendedor != null)
			hql = hql + " WHERE c.codVendedor = :codVendedor";

		Query query = em.createQuery(hql);

		if (codVendedor != null)
			query.setParameter("codVendedor", codVendedor);

		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public EnCliente buscarPorIdSemLazyEnderecos(Integer id) {
		Criteria c = getCriteria();
		c.add(Restrictions.idEq(id));
		c.setFetchMode("listaEnderecosCliente", FetchMode.JOIN);
		return (EnCliente) c.uniqueResult();
	}

}
