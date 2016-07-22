package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoCliente;
import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnCliente;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;

@Named
@ViewAccessScoped
public class MbCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnCliente cliente;
	private List<EnCliente> clientes;
	private List<DtoVendedor> vendedores;
	private String cpfCpnj;

	@Inject
	private BoCliente boCliente;

	@Inject
	private BoVendedor boVendedor;

	@PostConstruct
	public void init() {
		cliente = new EnCliente();
	}

	public String novo() {
		cliente = new EnCliente();
		preparaListas();
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(EnCliente clienteSelecionado) {
		cliente = clienteSelecionado;
		preparaListas();
		return "form.xhtml?faces-redirect=true";
	}

	public void preparaListas() {
		vendedores = boVendedor.buscarTodosPorDto();
	}

	// TODO
	public void ver(EnCliente clienteSelecionado) {
		cliente = clienteSelecionado;
	}

	public String salvar() {
		EnCliente clienteSalvo = boCliente.salvaOuAtualiza(cliente);

		if (clienteSalvo != null)
			UtilsFaces.adicionarMsgSucessoPadrao();
		else
			UtilsFaces.adicionarMsgErroPadrao();

		return "form.xhtml?faces-redirect=true";

	}

	public String getCpfCpnj() {
		return cpfCpnj;
	}

	public void setCpfCpnj(String cpfCpnj) {
		this.cpfCpnj = cpfCpnj;
	}

	public EnCliente getCliente() {
		return cliente;
	}

	public void setCliente(EnCliente cliente) {
		this.cliente = cliente;
	}

	public List<EnCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<EnCliente> clientes) {
		this.clientes = clientes;
	}

	public List<DtoVendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<DtoVendedor> vendedores) {
		this.vendedores = vendedores;
	}

}
