package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.bussiness.BoGrupo;
import br.com.victorinodelicias.sysdistri.bussiness.BoProduto;
import br.com.victorinodelicias.sysdistri.entity.EnGrupo;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;
import br.com.victorinodelicias.sysdistri.util.UtilsMensagem;

@Named
@ViewAccessScoped
public class MbGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnGrupo grupo;
	private List<EnGrupo> listaGrupos;

	@Inject
	private BoGrupo boGrupo;

	@Inject
	BoProduto boProduto;

	@PostConstruct
	public void init() {
		grupo = new EnGrupo();
		listaGrupos = boGrupo.listarTodos();
	}

	public String salvar() {
		EnGrupo retorno = boGrupo.salvaOuAtualiza(grupo);

		if (retorno != null) {
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);
			listaGrupos.remove(grupo);
			grupo = boGrupo.buscarPorCodigoSemLazyProdutos(retorno.getCodigo());
			listaGrupos.add(grupo);
		} else {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
		}

		return "listar.xhtml?faces-redirect=true";
	}

	public String novo() {
		grupo = new EnGrupo();
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(EnGrupo grupoSelecionado) {
		grupo = grupoSelecionado;
		return "form.xhtml?faces-redirect=true";
	}

	public void deletar(EnGrupo grupoSelecionado) {
		try {
			boGrupo.remover(grupoSelecionado);
			listaGrupos.remove(grupoSelecionado);
			UtilsFaces.adicionarMsgInfo(UtilsMensagem.MENSAGEM_SUCESSO);
		} catch (Exception e) {
			UtilsFaces.adicionarMsgErro(UtilsMensagem.MENSAGEM_ERRO_INTERNO);
			e.printStackTrace();
		}
	}

	public void verDados(EnGrupo grupoSelecionado) {
		grupoSelecionado.setListaProdutos(boProduto.buscarPorGrupoSemLazyUnidade(grupoSelecionado.getCodigo()));
		grupo = grupoSelecionado;
	}

	public EnGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(EnGrupo grupo) {
		this.grupo = grupo;
	}

	public List<EnGrupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<EnGrupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

}
