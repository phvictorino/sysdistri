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

	private Integer codigoAtalho;
	private Integer codigoProduto;
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

	public void buscarPorCodigo() {
		if (codigoProduto != null && codigoProduto.intValue() > 0) {
			produto = boProduto.buscarPorId(codigoProduto);
			if (produto != null) {
				idProdutoResultado = produto.getCodigo();
				codigoProduto = produto.getCodigo();
				RequestContext.getCurrentInstance().execute("rcSetRetorno()");
			} else
				UtilsFaces.adicionarMsgErro("Nenhum produto encontrado!");
		} else
			UtilsFaces.adicionarMsgErro("Digite algum número.");
	}

	public void buscarPorCodigoAtalho() {
		if (codigoAtalho != null && codigoAtalho.intValue() > 0) {
			produto = boProduto.buscarPorCodigoAtalho(codigoAtalho);
			if (produto != null) {
				codigoProduto = produto.getCodigo();
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

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getCodigoAtalho() {
		return codigoAtalho;
	}

	public void setCodigoAtalho(Integer codigoAtalho) {
		this.codigoAtalho = codigoAtalho;
	}

}
