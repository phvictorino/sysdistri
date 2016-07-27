package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.dto.DtoPedidoBuscaLazy;
import br.com.victorinodelicias.sysdistri.dao.DaoPedido;
import br.com.victorinodelicias.sysdistri.entity.EnPedido;

public class BoPedido extends GenericBO<EnPedido> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoPedido daoPedido;

	@PostConstruct
	public void init() {
		this.dao = daoPedido;
	}

	public List<EnPedido> listaComLazyDataModel(DtoPedidoBuscaLazy dto) {
		return daoPedido.listaComLazyDataModel(dto);
	}

	public int qtdResultado(DtoPedidoBuscaLazy dto) {
		return daoPedido.qtdResultados(dto);
	}

	@Override
	public EnPedido salvaOuAtualiza(EnPedido pedido) {

		if (pedido.getCodigo() == null)
			pedido.setDataEntrada(new Date());
		
		
		return super.salvaOuAtualiza(pedido);
	}

	public EnPedido buscarSemLazyProdutos(Integer codigo) {
		return daoPedido.buscarSemLazyProdutos(codigo);
	}

}
