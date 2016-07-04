package br.com.victorinodelicias.sysdistri.bussiness;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoGrupo;
import br.com.victorinodelicias.sysdistri.entity.EnGrupo;

public class BoGrupo extends GenericBO<EnGrupo> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoGrupo daoGrupo;

	@PostConstruct
	public void init() {
		this.dao = daoGrupo;
	}

	public EnGrupo buscarPorCodigoSemLazyProdutos(Integer codigo) {
		return daoGrupo.buscarPorCodigoSemLazyProdutos(codigo);
	}

}
