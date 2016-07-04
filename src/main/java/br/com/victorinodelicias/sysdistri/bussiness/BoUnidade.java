package br.com.victorinodelicias.sysdistri.bussiness;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoUnidade;
import br.com.victorinodelicias.sysdistri.entity.EnUnidade;

public class BoUnidade extends GenericBO<EnUnidade> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DaoUnidade daoUnidade;
	
	@PostConstruct
	private void init() {
		this.dao = daoUnidade;
	}

}
