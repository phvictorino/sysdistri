package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnVendedor;
import br.com.victorinodelicias.sysdistri.enums.EnumTipoFaturamento;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;

@Named
@ViewScoped
public class MbVendedor implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EnVendedor> vendedores;
	private List<EnumTipoFaturamento> listaTipoFaturamento;
	private EnVendedor vendedor;

	@Inject
	private BoVendedor boVendedor;

	@PostConstruct
	public void init() {

		if (UtilsFaces.getSessionMapValue("vendedor") != null) {
			vendedor = (EnVendedor) UtilsFaces.getSessionMapValue("vendedor");
			UtilsFaces.removeSessionMapValue("vendedor");
		} else
			vendedor = new EnVendedor();

		vendedores = new ArrayList<EnVendedor>();
		vendedores = boVendedor.listarTodos();
		listaTipoFaturamento = EnumTipoFaturamento.getValues();
	}

	public String novo() {
		vendedor = new EnVendedor();
		return "form.xhtml?faces-redirect=true";
	}

	public String salvar() {

		if (vendedor != null) {
			EnVendedor retorno = boVendedor.salvaOuAtualiza(vendedor);

			if (retorno != null) {
				UtilsFaces.adicionarMsgInfo("Vendedor salvo com sucesso.");
			} else {
				UtilsFaces.showErrorDialog("Erro ao salvar vendedor.");
			}
		}

		return "listar.xhtml?faces-redirect=true";

	}

	public String editar(EnVendedor vendedorSelecionado) {

		if (vendedorSelecionado.getCodigo() != null) {
			UtilsFaces.setSessionMapValue("vendedor", vendedorSelecionado);
			return "form.xhtml?faces-redirect=true";
		} else {
			UtilsFaces.adicionarMsgErro("Erro interno.");
			return "listar.xhtml?faces-redirect=true";
		}
	}

	public List<EnVendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<EnVendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public List<EnumTipoFaturamento> getListaTipoFaturamento() {
		return listaTipoFaturamento;
	}

	public void setListaTipoFaturamento(List<EnumTipoFaturamento> listaTipoFaturamento) {
		this.listaTipoFaturamento = listaTipoFaturamento;
	}

	public EnVendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(EnVendedor vendedor) {
		this.vendedor = vendedor;
	}

}
