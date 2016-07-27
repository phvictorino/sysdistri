package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import br.com.victorinodelicias.sysdistri.entity.EnRota;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;

public class DaoRota extends GenericDAO<EnRota> {

	private static final long serialVersionUID = 1L;

	public EnRota buscarSemLazyClientes(Integer codigo) {
		Criteria c = getCriteria();
		c.add(Restrictions.eq("codigo", codigo))
				.createAlias("listaEnderecosCliente", "endCli", JoinType.LEFT_OUTER_JOIN)
				.createAlias("endCli.cidade", "cid", JoinType.LEFT_OUTER_JOIN)
				.createAlias("endCli.cliente", "cliente", JoinType.LEFT_OUTER_JOIN);
		return (EnRota) c.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<EnRota> buscarTodosAtivosPorVendedor(Integer codVendedor) {
		Criteria c = getCriteria();
		c.add(Restrictions.eq("status", EnumStatus.ATIVO.getCodigo()));
		c.add(Restrictions.eq("codVendedor", codVendedor));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<EnRota> listarTodosSemLazyEnderecoCliente() {
		Criteria c = getCriteria();
		c.setFetchMode("listaEnderecosCliente", FetchMode.JOIN);
		return c.list();
	}

}
