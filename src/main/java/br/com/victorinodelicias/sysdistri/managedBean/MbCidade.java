package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.bussiness.BoCidade;
import br.com.victorinodelicias.sysdistri.entity.EnCidade;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;

@Named
@ViewAccessScoped
public class MbCidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnCidade cidade;
	private List<EnCidade> listaCidades;

	@Inject
	private BoCidade boCidade;

	@PostConstruct
	public void init() {
		listaCidades = boCidade.listarTodos();
	}

	public String novo() {
		cidade = new EnCidade();
		return "form.xhtml?faces-redirect=true";
	}

	public String salvar() {
		if (cidade != null) {
			EnCidade retorno = boCidade.salvaOuAtualiza(cidade);

			if (retorno != null) {
				UtilsFaces.adicionarMsgInfo("Cidade adicionada com sucesso.");

				if (!listaCidades.contains(retorno))
					listaCidades.add(retorno);
			} else
				UtilsFaces.adicionarMsgErro("Erro interno.");

		} else
			UtilsFaces.adicionarMsgErro("Erro interno.");

		return "listar.xhtml?faces-redirect=true";

	}

	public String editar(EnCidade cidadeSelecionada) {

		if (cidadeSelecionada != null) {
			cidade = cidadeSelecionada;
		}

		return "form.xhtml?faces-redirect=true";

	}

	public void deletar(EnCidade cidadeSelecionada) {
		if (cidadeSelecionada != null) {
			try {
				boCidade.remover(cidadeSelecionada);
				listaCidades.remove(cidadeSelecionada);
				UtilsFaces.adicionarMsgInfo("Cidade removida com sucesso.");
			} catch (Exception e) {
				UtilsFaces.adicionarMsgErro("Erro ao remover cidade");
				e.printStackTrace();
			}
		}
	}

	public EnCidade getCidade() {
		return cidade;
	}

	public void setCidade(EnCidade cidade) {
		this.cidade = cidade;
	}

	public List<EnCidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<EnCidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

}
