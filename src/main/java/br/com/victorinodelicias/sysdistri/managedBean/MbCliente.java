package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.dto.DtoCliente;
import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoCliente;
import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnCliente;
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

	@Inject
	private BoCliente boCliente;

	@Inject
	private BoVendedor boVendedor;

	@PostConstruct
	public void init() {
		clientes = boCliente.buscarTodosPorDto(null);
		cliente = new EnCliente();
		tiposPessoa = EnumTipoPessoa.getValues();
	}

	public String novo() {
		cliente = new EnCliente();
		preparaListas();
		cliente.setTipo(EnumTipoPessoa.FISICA.getCodigo());
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(DtoCliente clienteSelecionado) {
		cliente = boCliente.buscarPorId(clienteSelecionado.getId());
		preparaListas();
		return "form.xhtml?faces-redirect=true";
	}

	public void preparaListas() {
		vendedores = boVendedor.buscarTodosPorDto();
	}

	// TODO
	public void verDados(DtoCliente clienteSelecionado) {
//		cliente = clienteSelecionado;
	}

	// TODO
	public void desativar(DtoCliente clienteSelecionado) {
//		cliente = clienteSelecionado;
	}

	public String salvar() {
		EnCliente clienteSalvo = boCliente.salvaOuAtualiza(cliente);

		if (clienteSalvo != null)
			UtilsFaces.adicionarMsgSucessoPadrao();
		else
			UtilsFaces.adicionarMsgErroPadrao();
		
		clientes = boCliente.buscarTodosPorDto(null);
		
		return "listar.xhtml?faces-redirect=true";

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

}
