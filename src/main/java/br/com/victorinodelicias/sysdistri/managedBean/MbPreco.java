package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.event.RowEditEvent;

import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoGrupo;
import br.com.victorinodelicias.sysdistri.bussiness.BoPreco;
import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnGrupo;
import br.com.victorinodelicias.sysdistri.entity.EnPreco;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;

@Named
@ViewAccessScoped
public class MbPreco implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EnPreco> listaPrecos;
	private EnPreco preco;
	private Integer codGrupoSelecionado;
	private List<EnGrupo> listaGrupos;
	private List<DtoVendedor> listaVendedores;

	@Inject
	private BoPreco boPreco;

	@Inject
	private BoGrupo boGrupo;

	@Inject
	private BoVendedor boVendedor;

	@PostConstruct
	public void init() {
		preco = new EnPreco();
		listaPrecos = boPreco.listarTodosSemLazyVendedorEProdutos();
		listaGrupos = boGrupo.listarTodos();
		listaVendedores = boVendedor.buscarTodosPorDto();
	}

	public String novo() {
		preco = new EnPreco();
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(EnPreco precoSelecionado) {
		preco = precoSelecionado;
		return "form.xhtml?faces-redirect=true";
	}

	public void alterarStatus(EnPreco precoSelecionado) {
		if (precoSelecionado.getEnumStatus().equals(EnumStatus.ATIVO))
			precoSelecionado.setStatus(EnumStatus.INATIVO.getCodigo());
		else
			precoSelecionado.setStatus(EnumStatus.ATIVO.getCodigo());
	}

	public void salvar() {
		try {
			boPreco.salvaPrecoPorGrupo(preco, codGrupoSelecionado);
			UtilsFaces.adicionarMsgSucessoPadrao();
		} catch (Exception e) {
			UtilsFaces.adicionarMsgErroPadrao();
			e.printStackTrace();
		}

	}

	public void onRowEdit(RowEditEvent event) {
		EnPreco precoEditado = (EnPreco) event.getObject();

		try {
			boPreco.salvaOuAtualiza(precoEditado);
			UtilsFaces.adicionarMsgSucessoPadrao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String salvarESair() {
		this.salvar();
		return "listar.xhtml?faces-redirect=true";
	}

	public void salvarEFicar() {
		this.salvar();
	}

	public List<EnPreco> getListaPrecos() {
		return listaPrecos;
	}

	public void setListaPrecos(List<EnPreco> listaPrecos) {
		this.listaPrecos = listaPrecos;
	}

	public EnPreco getPreco() {
		return preco;
	}

	public void setPreco(EnPreco preco) {
		this.preco = preco;
	}

	public Integer getCodGrupoSelecionado() {
		return codGrupoSelecionado;
	}

	public void setCodGrupoSelecionado(Integer codGrupoSelecionado) {
		this.codGrupoSelecionado = codGrupoSelecionado;
	}

	public List<EnGrupo> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<EnGrupo> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<DtoVendedor> getListaVendedores() {
		return listaVendedores;
	}

	public void setListaVendedores(List<DtoVendedor> listaVendedores) {
		this.listaVendedores = listaVendedores;
	}

}
