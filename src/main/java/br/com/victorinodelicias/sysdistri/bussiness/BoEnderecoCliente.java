package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoEnderecoCliente;
import br.com.victorinodelicias.sysdistri.entity.EnEnderecoCliente;

public class BoEnderecoCliente extends GenericBO<EnEnderecoCliente> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DaoEnderecoCliente daoEnderecoCliente;
	
	@PostConstruct
	public void init() {
		this.dao = daoEnderecoCliente;
	}

	public List<EnEnderecoCliente> buscarPorIdCliente(Integer codigo) {
		return daoEnderecoCliente.buscarPorIdCliente(codigo);
	}

}
