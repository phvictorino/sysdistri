package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.dto.DtoCliente;
import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoCidade;
import br.com.victorinodelicias.sysdistri.bussiness.BoCliente;
import br.com.victorinodelicias.sysdistri.bussiness.BoEnderecoCliente;
import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnCidade;
import br.com.victorinodelicias.sysdistri.entity.EnCliente;
import br.com.victorinodelicias.sysdistri.entity.EnEnderecoCliente;
import br.com.victorinodelicias.sysdistri.enums.EnumStatusEndereco;
import br.com.victorinodelicias.sysdistri.enums.EnumTipoPessoa;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;

@Named
@ViewAccessScoped
public class MbCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnCliente cliente;
	private List<DtoCliente> clientes;
	private List<DtoVendedor> vendedores;
	private List<EnumTipoPessoa> tiposPessoa;
	private EnEnderecoCliente enderecoCliente;
	private List<EnCidade> cidades;
	boolean novoCliente;

	@Inject
	private BoCliente boCliente;

	@Inject
	private BoVendedor boVendedor;

	@Inject
	private BoCidade boCidade;

	@Inject
	private BoEnderecoCliente boEnderecoCliente;

	@PostConstruct
	public void init() {
		clientes = boCliente.buscarTodosPorDto(null);
		cliente = new EnCliente();
		tiposPessoa = EnumTipoPessoa.getValues();
		enderecoCliente = new EnEnderecoCliente();
		cidades = boCidade.listarTodos();
	}

	public String novo() {
		cliente = new EnCliente();
		preparaListas();
		cliente.setTipo(EnumTipoPessoa.FISICA.getCodigo());
		novoCliente = true;
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(DtoCliente clienteSelecionado) {
		cliente = boCliente.buscarPorIdSemLazyEnderecos(clienteSelecionado.getId());
		preparaListas();
		novoCliente = false;
		return "form.xhtml?faces-redirect=true";
	}

	public void preparaListas() {
		vendedores = boVendedor.buscarTodosPorDto();
	}

	// TODO
	public void verDados(DtoCliente clienteSelecionado) {
		// cliente = clienteSelecionado;
	}

	// TODO
	public void desativar(DtoCliente clienteSelecionado) {
		// cliente = clienteSelecionado;
	}

	public void salvar() {

		if (cliente.getCodigo() == null)
			novoCliente = true;

		EnCliente clienteSalvo = boCliente.salvaOuAtualiza(cliente);

		if (clienteSalvo != null) {
			UtilsFaces.adicionarMsgSucessoPadrao();
			novoCliente = false;
			cliente = clienteSalvo;
		} else
			UtilsFaces.adicionarMsgErroPadrao();

		clientes = boCliente.buscarTodosPorDto(null);

	}

	public void salvarEndereco() {

		if (cliente.getCodigo() != null) {

			if (enderecoCliente.getCodCliente() == null)
				enderecoCliente.setCodCliente(cliente.getCodigo());

			enderecoCliente.setEnderecoAtual(EnumStatusEndereco.ATIVO.getCodigo());

			EnEnderecoCliente objSalvo = boEnderecoCliente.salvaOuAtualiza(enderecoCliente);

			if (objSalvo != null) {
				UtilsFaces.adicionarMsgSucessoPadrao();

				cliente.setListaEnderecosCliente(boEnderecoCliente.buscarPorIdCliente(cliente.getCodigo()));

				enderecoCliente = new EnEnderecoCliente();

			} else
				UtilsFaces.adicionarMsgErroPadrao();

		} else
			UtilsFaces.adicionarMsgErro("O cliente deve estar salvo para poder salvar um endereço.");

	}

	public void alteraStatusEndereco(EnEnderecoCliente enderecoClienteSelecionado) {

		if (enderecoClienteSelecionado.getEnderecoAtual().intValue() == EnumStatusEndereco.ATIVO.getCodigo()
				.intValue()) {
			enderecoClienteSelecionado.setEnderecoAtual(EnumStatusEndereco.INATIVO.getCodigo());
		} else {
			enderecoClienteSelecionado.setEnderecoAtual(EnumStatusEndereco.ATIVO.getCodigo());
		}
		
		boEnderecoCliente.salvaOuAtualiza(enderecoClienteSelecionado);

	}

	public void limparEndereco() {
		this.enderecoCliente = new EnEnderecoCliente();
	}

	public void editarEndereco(EnEnderecoCliente enderecoSelecionado) {
		this.enderecoCliente = enderecoSelecionado;
	}

	public EnCliente getCliente() {
		return cliente;
	}

	public void setCliente(EnCliente cliente) {
		this.cliente = cliente;
	}

	public List<DtoVendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<DtoVendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public List<EnumTipoPessoa> getTiposPessoa() {
		return tiposPessoa;
	}

	public void setTiposPessoa(List<EnumTipoPessoa> tiposPessoa) {
		this.tiposPessoa = tiposPessoa;
	}

	public List<DtoCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<DtoCliente> clientes) {
		this.clientes = clientes;
	}

	public EnEnderecoCliente getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(EnEnderecoCliente enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public List<EnCidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<EnCidade> cidades) {
		this.cidades = cidades;
	}

	public boolean isNovoCliente() {
		return novoCliente;
	}

	public void setNovoCliente(boolean novoCliente) {
		this.novoCliente = novoCliente;
	}

}
