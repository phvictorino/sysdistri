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
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;

@Named
@ViewAccessScoped
public class MbCompProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codAtalho;
	private List<DtoProduto> listaDtoProdutos;
	private Integer idProdutoResultado;
	private EnProduto produto;

	@Inject
	private BoProduto boProduto;

	@PostConstruct
	public void init() {
		listaDtoProdutos = boProduto.listarTodosPorDto();
		produto = new EnProduto();
	}

	public void buscarPorCodigoAtalho() {
		if (codAtalho != null && codAtalho.intValue() > 0) {
			produto = boProduto.buscarPorCodigoAtalho(codAtalho);
			if (produto != null) {
				idProdutoResultado = produto.getCodigo();
				RequestContext.getCurrentInstance().execute("rcSetRetorno()");
			} else
				UtilsFaces.adicionarMsgErro("Nenhum produto encontrado!");
		} else
			UtilsFaces.adicionarMsgErro("Digite algum número.");
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

	public Integer getIdProdutoResultado() {
		return idProdutoResultado;
	}

	public void setIdProdutoResultado(Integer idProdutoResultado) {
		this.idProdutoResultado = idProdutoResultado;
	}

	public EnProduto getProduto() {
		return produto;
	}

	public void setProduto(EnProduto produto) {
		this.produto = produto;
	}

}
