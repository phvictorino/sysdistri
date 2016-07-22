package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.victorinodelicias.dto.DtoCliente;
import br.com.victorinodelicias.dto.DtoPedidoBuscaLazy;
import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoCliente;
import br.com.victorinodelicias.sysdistri.bussiness.BoFormaPagamento;
import br.com.victorinodelicias.sysdistri.bussiness.BoPedido;
import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnFormaPagamento;
import br.com.victorinodelicias.sysdistri.entity.EnPedido;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;
import br.com.victorinodelicias.sysdistri.util.UtilsMensagem;

@Named
@ViewAccessScoped
public class MbPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnPedido pedido;
	private List<EnPedido> listaPedidos;
	private LazyDataModel<EnPedido> modelPedidos;
	private List<DtoVendedor> vendedores;
	private List<DtoCliente> clientes;
	private List<EnFormaPagamento> formasPagamento;

	@Inject
	private BoPedido boPedido;

	@Inject
	private BoVendedor boVendedor;

	@Inject
	private BoCliente boCliente;

	@Inject
	private BoFormaPagamento boFormaPagamento;

	@PostConstruct
	public void init() {
		pedido = new EnPedido();
		criaListaPedidos();
	}

	private void criaListaPedidos() {
		modelPedidos = new LazyDataModel<EnPedido>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<EnPedido> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				DtoPedidoBuscaLazy dto = new DtoPedidoBuscaLazy();
				dto.setPrimeiroRegistro(first);
				dto.setQtdRegistros(pageSize);
				dto.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
				dto.setAtributoOrdenacao(sortField);
				setRowCount(boPedido.qtdResultado(dto));
				return boPedido.listaComLazyDataModel(dto);
			}
		};
	}

	public String novo() {
		pedido = new EnPedido();
		preparaListas();
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(EnPedido pedidoSelecionado) {
		pedido = pedidoSelecionado;
		preparaListas();
		return "form.xhtml?faces-redirect=true";
	}

	private void preparaListas() {
		vendedores = boVendedor.buscarTodosPorDto();
		clientes = boCliente.buscarTodosPorDto(pedido.getCodVendedor());
		formasPagamento = boFormaPagamento.listarTodos();
	}

	public void ver(EnPedido produtoSelecionado) {
		System.out.println("Ver pedido");
	}

	public String salvar() {
		EnPedido pedidoSalvo = boPedido.salvaOuAtualiza(pedido);

		if (pedidoSalvo != null) {
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);
		} else {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
		}
		
		return "listar.xhtml?faces-redirect=true";
	}

	public EnPedido getPedido() {
		return pedido;
	}

	public void setPedido(EnPedido pedido) {
		this.pedido = pedido;
	}

	public List<EnPedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<EnPedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public LazyDataModel<EnPedido> getModelPedidos() {
		return modelPedidos;
	}

	public void setModelPedidos(LazyDataModel<EnPedido> modelPedidos) {
		this.modelPedidos = modelPedidos;
	}

	public List<DtoVendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<DtoVendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public List<DtoCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<DtoCliente> clientes) {
		this.clientes = clientes;
	}

	public List<EnFormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<EnFormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

}
