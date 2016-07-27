package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.dao.DaoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnVendedor;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;

public class BoVendedor extends GenericBO<EnVendedor> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoVendedor daoVendedor;

	@PostConstruct
	public void init() {
		this.dao = daoVendedor;
	}

	public DtoVendedor buscarPorIdDto(Integer id) {
		return daoVendedor.buscarPorIdDto(id);
	}

	public List<DtoVendedor> buscarTodosPorDto() {
		return daoVendedor.buscarTodosPorDto();
	}

	@Override
	public EnVendedor salvaOuAtualiza(EnVendedor obj) {
		if (obj.getCodigo() == null)
			obj.setStatus(EnumStatus.ATIVO.getCodigo());
		return super.salvaOuAtualiza(obj);
	}

}
