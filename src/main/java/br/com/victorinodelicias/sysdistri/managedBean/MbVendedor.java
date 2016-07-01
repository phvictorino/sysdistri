package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnVendedor;
import br.com.victorinodelicias.sysdistri.enums.EnumTipoFaturamento;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;
import br.com.victorinodelicias.sysdistri.util.UtilsMensagem;

@Named
@ViewAccessScoped
public class MbVendedor implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EnVendedor> vendedores;
	private List<EnumTipoFaturamento> listaTipoFaturamento;
	private EnVendedor vendedor;

	@Inject
	private BoVendedor boVendedor;

	@PostConstruct
	public void init() {

		// if (UtilsFaces.getSessionMapValue("vendedor") != null) {
		// vendedor = (EnVendedor) UtilsFaces.getSessionMapValue("vendedor");
		// UtilsFaces.removeSessionMapValue("vendedor");
		// } else
		// vendedor = new EnVendedor();

		vendedores = new ArrayList<EnVendedor>();
		vendedores = boVendedor.listarTodos();
		listaTipoFaturamento = EnumTipoFaturamento.getValues();
	}

	public String novo() {
		vendedor = new EnVendedor();
		return "form.xhtml";
	}

	public void salvar() {

		if (vendedor != null) {
			EnVendedor retorno = boVendedor.salvaOuAtualiza(vendedor);

			if (retorno != null) {
				UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);

				vendedores.remove(vendedor);
				vendedores.add(retorno);
			} else {
				UtilsFaces.showErrorDialog(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
			}
		}

		UtilsFaces.redirecionar("private/vendedor/listar.xhtml");

	}

	public String editar(EnVendedor vendedorSelecionado) {

		if (vendedorSelecionado != null) {
			this.vendedor = vendedorSelecionado;
			return "form.xhtml?faces-redirect=true";
		} else {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
			return "listar.xhtml?faces-redirect=true";
		}
	}

	public void deletar(EnVendedor vendedorSelecionado) {
		try {
			boVendedor.remover(vendedorSelecionado);
			vendedores.remove(vendedorSelecionado);
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);
		} catch (Exception e) {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
			e.printStackTrace();
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
