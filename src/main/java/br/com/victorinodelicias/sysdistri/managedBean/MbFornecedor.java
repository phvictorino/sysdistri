package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.bussiness.BoCidade;
import br.com.victorinodelicias.sysdistri.bussiness.BoFornecedor;
import br.com.victorinodelicias.sysdistri.entity.EnCidade;
import br.com.victorinodelicias.sysdistri.entity.EnFornecedor;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;
import br.com.victorinodelicias.sysdistri.enums.EnumTipoFaturamento;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;
import br.com.victorinodelicias.sysdistri.util.UtilsMensagem;

@Named
@ViewAccessScoped
public class MbFornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnFornecedor fornecedor;
	private List<EnFornecedor> listaFornecedores;
	private List<EnCidade> listaCidades;
	private List<EnumTipoFaturamento> listaTipoFaturamentos;

	@Inject
	private BoFornecedor boFornecedor;

	@Inject
	BoCidade boCidade;

	@PostConstruct
	public void init() {
		listaFornecedores = boFornecedor.listarTodos();
		listaCidades = boCidade.listarTodos();
		listaTipoFaturamentos = EnumTipoFaturamento.getValues();
	}

	public void verDados(EnFornecedor fornecedorSelecionado) {
		fornecedor = fornecedorSelecionado;
	}

	public String novo() {
		fornecedor = new EnFornecedor();
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(EnFornecedor fornecedorSelecionado) {
		if (fornecedorSelecionado != null) {
			fornecedor = fornecedorSelecionado;
			return "form.xhtml?faces-redirect=true";
		} else {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
			return null;
		}
	}

	public void salvar() {

		EnFornecedor retorno = boFornecedor.salvaOuAtualiza(fornecedor);

		if (retorno != null)
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);
		else
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);

		listaFornecedores = boFornecedor.listarTodos();

		UtilsFaces.redirecionar("private/fornecedor/listar.xhtml");
	}

	public void deletar(EnFornecedor fornecedorSelecionado) {
		try {
			boFornecedor.remover(fornecedorSelecionado);
			listaFornecedores.remove(fornecedorSelecionado);
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);
		} catch (Exception e) {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
			e.printStackTrace();
		}
	}

	public EnFornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(EnFornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<EnFornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<EnFornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	public List<EnCidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<EnCidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public List<EnumTipoFaturamento> getListaTipoFaturamentos() {
		return listaTipoFaturamentos;
	}

	public void setListaTipoFaturamentos(List<EnumTipoFaturamento> listaTipoFaturamentos) {
		this.listaTipoFaturamentos = listaTipoFaturamentos;
	}

}
