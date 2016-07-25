package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.dto.DtoCliente;
import br.com.victorinodelicias.sysdistri.dao.DaoCliente;
import br.com.victorinodelicias.sysdistri.entity.EnCliente;

public class BoCliente extends GenericBO<EnCliente> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoCliente daoCliente;

	@PostConstruct
	public void init() {
		this.dao = daoCliente;
	}

	public List<DtoCliente> buscarTodosPorDto(Integer codVendedor) {
		return daoCliente.buscarTodosPorDto(codVendedor);
	}

}
