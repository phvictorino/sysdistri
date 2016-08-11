package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;

import br.com.victorinodelicias.dto.DtoProduto;
import br.com.victorinodelicias.sysdistri.bussiness.BoProduto;
import br.com.victorinodelicias.sysdistri.entity.EnProduto;

@Named
@ViewAccessScoped
public class MbCompProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codAtalho;
	private Integer codProdSelecionado;
	private List<DtoProduto> listaDtoProdutos;
	private EnProduto resultado;

	@Inject
	private BoProduto boProduto;

	@PostConstruct
	public void init() {
		listaDtoProdutos = boProduto.listarTodosPorDto();
	}

	public void buscarPorCodigo() {
		resultado = boProduto.buscarPorId(codProdSelecionado);
		RequestContext.getCurrentInstance().execute("rcSetRetorno()");
	}

	public void buscarPorCodigoAtalho() {
		resultado = boProduto.buscarPorCodigoAtalho(codAtalho);
		RequestContext.getCurrentInstance().execute("rcSetRetorno()");
	}

	public List<DtoProduto> getListaDtoProdutos() {
		return listaDtoProdutos;
	}

	public void setListaDtoProdutos(List<DtoProduto> listaDtoProdutos) {
		this.listaDtoProdutos = listaDtoProdutos;
	}

	public Integer getCodAtalho() {
		return codAtalho;
	}

	public void setCodAtalho(Integer codAtalho) {
		this.codAtalho = codAtalho;
	}

	public EnProduto getResultado() {
		return resultado;
	}

	public void setResultado(EnProduto resultado) {
		this.resultado = resultado;
	}

	public Integer getCodProdSelecionado() {
		return codProdSelecionado;
	}

	public void setCodProdSelecionado(Integer codProdSelecionado) {
		this.codProdSelecionado = codProdSelecionado;
	}

}
