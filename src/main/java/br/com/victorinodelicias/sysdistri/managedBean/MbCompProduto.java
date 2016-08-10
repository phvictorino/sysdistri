package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.bussiness.BoProduto;
import br.com.victorinodelicias.sysdistri.entity.EnProduto;

@Named
@ViewAccessScoped
public class MbCompProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnProduto produtoBusca;

	@Inject
	private BoProduto boProduto;

	@PostConstruct
	public void init() {
		produtoBusca = new EnProduto();
	}

	public EnProduto getProdutoBusca() {
		return produtoBusca;
	}

	public void setProdutoBusca(EnProduto produtoBusca) {
		this.produtoBusca = produtoBusca;
	}

}
