package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.bussiness.BoPreco;
import br.com.victorinodelicias.sysdistri.entity.EnPreco;

@Named
@ViewAccessScoped
public class MbPreco implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<EnPreco> listaPrecos;
	private EnPreco preco;

	@Inject
	private BoPreco boPreco;

	@PostConstruct
	public void init() {
		listaPrecos = boPreco.listarTodosSemLazyVendedor();
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

}
