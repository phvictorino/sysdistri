package br.com.victorinodelicias.sysdistri.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import br.com.victorinodelicias.dto.DtoPedidoBuscaLazy;
import br.com.victorinodelicias.sysdistri.entity.EnPedido;

public class DaoPedido extends GenericDAO<EnPedido> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<EnPedido> listaComLazyDataModel(DtoPedidoBuscaLazy dto) {

		Criteria c = getCriteria();

		c.setFirstResult(dto.getPrimeiroRegistro());
		c.setMaxResults(dto.getQtdRegistros());

		if (dto.isAscendente() && dto.getAtributoOrdenacao() != null)
			c.addOrder(Order.asc(dto.getAtributoOrdenacao()));
		else if (dto.getAtributoOrdenacao() != null)
			c.addOrder(Order.desc(dto.getAtributoOrdenacao()));

		return (List<EnPedido>) c.list();
	}
	
	public int qtdResultados(DtoPedidoBuscaLazy dto) {
		Criteria c = getCriteria();
		
		c.setProjection(Projections.rowCount());
		
		return ((Number) c.uniqueResult()).intValue();
	}

}