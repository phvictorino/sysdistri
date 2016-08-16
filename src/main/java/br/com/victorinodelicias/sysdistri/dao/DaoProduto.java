package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import br.com.victorinodelicias.dto.DtoProduto;
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

	@SuppressWarnings("unchecked")
	public List<EnProduto> listarTodosSemLazyFornecedor() {
		Criteria c = getCriteria();
		c.setFetchMode("fornecedor", FetchMode.JOIN);
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<DtoProduto> listarTodosPorDto() {

		String hql = "SELECT new br.com.victorinodelicias.dto.DtoProduto( ";
		hql = hql + " p.codigo, p.descricao, p.codAtalho ) ";
		hql = hql + " FROM EnProduto p ";

		Query query = em.createQuery(hql);

		try {
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public EnProduto buscarPorCodigoAtalho(Integer codAtalho) {
		Criteria c = getCriteria();
		c.add(Restrictions.eq("codAtalho", codAtalho));
		return (EnProduto) c.uniqueResult();
	}

}
