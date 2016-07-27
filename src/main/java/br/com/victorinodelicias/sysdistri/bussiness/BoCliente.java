package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.dto.DtoCliente;
import br.com.victorinodelicias.sysdistri.dao.DaoCliente;
import br.com.victorinodelicias.sysdistri.entity.EnCliente;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;

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

	public EnCliente buscarPorIdSemLazyEnderecos(Integer id) {
		return daoCliente.buscarPorIdSemLazyEnderecos(id);
	}

	@Override
	public EnCliente salvaOuAtualiza(EnCliente obj) {
		if (obj.getCodigo() == null)
			obj.setStatus(EnumStatus.ATIVO.getCodigo());
		return super.salvaOuAtualiza(obj);
	}

}
