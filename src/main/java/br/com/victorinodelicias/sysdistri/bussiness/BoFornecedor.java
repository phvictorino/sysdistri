package br.com.victorinodelicias.sysdistri.bussiness;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoFornecedor;
import br.com.victorinodelicias.sysdistri.entity.EnFornecedor;

public class BoFornecedor extends GenericBO<EnFornecedor> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoFornecedor daoFornecedor;

	@PostConstruct
	public void init() {
		this.dao = daoFornecedor;
	}

}
