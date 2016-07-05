package br.com.victorinodelicias.sysdistri.managedBean;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.bussiness.BoFornecedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoGrupo;
import br.com.victorinodelicias.sysdistri.bussiness.BoProduto;
import br.com.victorinodelicias.sysdistri.bussiness.BoUnidade;
import br.com.victorinodelicias.sysdistri.entity.EnFornecedor;
import br.com.victorinodelicias.sysdistri.entity.EnGrupo;
import br.com.victorinodelicias.sysdistri.entity.EnProduto;
import br.com.victorinodelicias.sysdistri.entity.EnUnidade;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;
import br.com.victorinodelicias.sysdistri.util.UtilsMensagem;

import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class MbProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnProduto produto;
	private List<EnProduto> listaProdutos;
	private List<EnGrupo> listaGrupos;
	private List<EnUnidade> listaUnidades;
	private List<EnFornecedor> listaFornecedor;

	@Inject
	private BoProduto boProduto;

	@Inject
	private BoGrupo boGrupo;

	@Inject
	private BoUnidade boUnidade;

	@Inject
	private BoFornecedor boFornecedor;

	@PostConstruct
	public void init() {
		produto = new EnProduto();
		listaProdutos = boProduto.listarTodosSemLazyFornecedor();
		listaGrupos = boGrupo.listarTodos();
		listaUnidades = boUnidade.listarTodos();
		listaFornecedor = boFornecedor.listarTodos();
	}

	public void novo() {
		produto = new EnProduto();
		// return "form.xhtml?faces-redirect=true";
		UtilsFaces.redirecionar("private/produto/form.xhtml");
	}

	public void editar(EnProduto produtoSelecionado) {
		produto = produtoSelecionado;
		// return "form.xhtml?faces-redirect=true";
		UtilsFaces.redirecionar("private/produto/form.xhtml");
	}

	public void salvar() {
		EnProduto retorno = boProduto.salvaOuAtualiza(produto);

		if (retorno != null) {
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);

			listaProdutos.remove(produto);
			listaProdutos.add(retorno);
		} else
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);

		// return "listar.xhtml?faces-redirect=true";
		UtilsFaces.redirecionar("private/produto/form.xhtml");
	}

	public void deletar(EnProduto produtoSelecionado) {
		try {
			boProduto.remover(produtoSelecionado);
			listaProdutos.remove(produtoSelecionado);
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);
		} catch (Exception e) {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
			e.printStackTrace();
		}
	}

	public EnProduto getProduto() {
		return produto;
	}

	public void setProduto(EnProduto produto) {
		this.produto = produto;
	}

	public List<EnProduto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<EnProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public List<EnGrupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<EnGrupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<EnUnidade> getListaUnidades() {
		return listaUnidades;
	}

	public void setListaUnidades(List<EnUnidade> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}

	public List<EnFornecedor> getListaFornecedor() {
		return listaFornecedor;
	}

	public void setListaFornecedor(List<EnFornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}

}
