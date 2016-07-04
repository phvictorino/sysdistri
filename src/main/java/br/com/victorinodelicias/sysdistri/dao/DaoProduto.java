package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import br.com.victorinodelicias.sysdistri.entity.EnProduto;

public class DaoProduto extends GenericDAO<EnProduto> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<EnProduto> buscarPorGrupoSemLazyUnidade(Integer codigo) {
		Criteria c = getCriteria();
		c.add(Restrictions.eq("codGrupo", codigo));
		c.setFetchMode("unidade", FetchMode.JOIN);
		return c.list();
	}

}
