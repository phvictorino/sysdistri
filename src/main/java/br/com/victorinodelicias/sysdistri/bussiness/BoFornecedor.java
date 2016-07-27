package br.com.victorinodelicias.sysdistri.bussiness;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoFornecedor;
import br.com.victorinodelicias.sysdistri.entity.EnFornecedor;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;

public class BoFornecedor extends GenericBO<EnFornecedor> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoFornecedor daoFornecedor;

	@PostConstruct
	public void init() {
		this.dao = daoFornecedor;
	}

	@Override
	public EnFornecedor salvaOuAtualiza(EnFornecedor obj) {
		if (obj.getCodigo() == null)
			obj.setStatus(EnumStatus.ATIVO.getCodigo());
		return super.salvaOuAtualiza(obj);
	}

}
