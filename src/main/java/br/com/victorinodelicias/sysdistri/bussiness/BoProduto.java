package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.dto.DtoProduto;
import br.com.victorinodelicias.sysdistri.dao.DaoProduto;
import br.com.victorinodelicias.sysdistri.entity.EnProduto;

public class BoProduto extends GenericBO<EnProduto> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoProduto daoProduto;

	@PostConstruct
	public void init() {
		this.dao = daoProduto;
	}

	public List<EnProduto> buscarPorGrupoSemLazyUnidade(Integer codigo) {
		return daoProduto.buscarPorGrupoSemLazyUnidade(codigo);
	}

	public List<EnProduto> listarTodosSemLazyFornecedor() {
		return daoProduto.listarTodosSemLazyFornecedor();
	}

	public List<DtoProduto> listarTodosPorDto() {
		return daoProduto.listarTodosPorDto();
	}

	public EnProduto buscarPorCodigoAtalho(Integer codAtalho) {
		return daoProduto.buscarPorCodigoAtalho(codAtalho);
	}

}
