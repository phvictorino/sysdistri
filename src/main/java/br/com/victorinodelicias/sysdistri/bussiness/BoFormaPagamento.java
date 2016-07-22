package br.com.victorinodelicias.sysdistri.bussiness;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoFormaPagamento;
import br.com.victorinodelicias.sysdistri.entity.EnFormaPagamento;

public class BoFormaPagamento extends GenericBO<EnFormaPagamento> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DaoFormaPagamento daoFormaPagamento;
	
	@PostConstruct
	public void init() {
		this.dao = daoFormaPagamento;
	}

}
