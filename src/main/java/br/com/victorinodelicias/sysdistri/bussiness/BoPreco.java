package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoPreco;
import br.com.victorinodelicias.sysdistri.entity.EnPreco;

public class BoPreco extends GenericBO<EnPreco> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoPreco daoPreco;

	@PostConstruct
	public void init() {
		this.dao = daoPreco;
	}

	public List<EnPreco> listarTodosSemLazyVendedor() {
		return daoPreco.listarTodosSemLazyVendedor();
	}

}
