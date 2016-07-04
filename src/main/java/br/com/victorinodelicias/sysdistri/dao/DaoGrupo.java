package br.com.victorinodelicias.sysdistri.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import br.com.victorinodelicias.sysdistri.entity.EnGrupo;

public class DaoGrupo extends GenericDAO<EnGrupo> implements Serializable {

	private static final long serialVersionUID = 1L;

	public EnGrupo buscarPorCodigoSemLazyProdutos(Integer codigo) {
		Criteria c = getCriteria();
		c.add(Restrictions.eq("codigo", codigo));
		c.setFetchMode("listaProdutos", FetchMode.JOIN);
		return (EnGrupo) c.uniqueResult();
	}

}
