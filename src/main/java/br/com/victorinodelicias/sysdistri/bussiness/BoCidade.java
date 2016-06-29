package br.com.victorinodelicias.sysdistri.bussiness;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoCidade;
import br.com.victorinodelicias.sysdistri.entity.EnCidade;

public class BoCidade extends GenericBO<EnCidade> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoCidade daoCidade;

	@PostConstruct
	public void init() {
		this.dao = daoCidade;
	}

}
