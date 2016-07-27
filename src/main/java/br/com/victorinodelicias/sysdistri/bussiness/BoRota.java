package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoRota;
import br.com.victorinodelicias.sysdistri.entity.EnRota;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;

public class BoRota extends GenericBO<EnRota> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoRota daoRota;

	@PostConstruct
	public void init() {
		this.dao = daoRota;
	}

	public EnRota buscarSemLazyClientes(Integer codigo) {
		return daoRota.buscarSemLazyClientes(codigo);
	}

	public List<EnRota> buscarTodosAtivosPorVendedor(Integer codVendedor) {
		return daoRota.buscarTodosAtivosPorVendedor(codVendedor);
	}

	public List<EnRota> listarTodosSemLazyEnderecoCliente() {
		return daoRota.listarTodosSemLazyEnderecoCliente();
	}

	@Override
	public EnRota salvaOuAtualiza(EnRota obj) {
		if (obj.getCodigo() == null)
			obj.setStatus(EnumStatus.ATIVO.getCodigo());
		return super.salvaOuAtualiza(obj);
	}

}
