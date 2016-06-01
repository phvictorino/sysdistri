package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoContasPR;
import br.com.victorinodelicias.sysdistri.entity.EnContasPr;

public class BoContasPR extends GenericBO<EnContasPr> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DaoContasPR daoContas;
	
	@PostConstruct
	public void init() {
		this.dao = daoContas;
	}
	

	public List<EnContasPr> listarContasReceber() {
		return daoContas.listarContasReceber();
	}

}
