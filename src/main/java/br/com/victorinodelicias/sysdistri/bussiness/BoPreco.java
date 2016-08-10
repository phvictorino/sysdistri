package br.com.victorinodelicias.sysdistri.bussiness;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.victorinodelicias.sysdistri.dao.DaoPreco;
import br.com.victorinodelicias.sysdistri.entity.EnGrupo;
import br.com.victorinodelicias.sysdistri.entity.EnPreco;
import br.com.victorinodelicias.sysdistri.entity.EnProduto;

public class BoPreco extends GenericBO<EnPreco> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DaoPreco daoPreco;

	@Inject
	private BoGrupo boGrupo;

	@Inject
	private BoProduto boProduto;

	@PostConstruct
	public void init() {
		this.dao = daoPreco;
	}

	public List<EnPreco> listarTodosSemLazyVendedor() {
		return daoPreco.listarTodosSemLazyVendedor();
	}

	public void salvaPrecoPorGrupo(EnPreco precoForm, Integer codGrupoSelecionado) {
		EnGrupo grupo = boGrupo.buscarPorCodigoSemLazyProdutos(codGrupoSelecionado);
		for (EnProduto p : grupo.getListaProdutos()) {
			EnPreco preco = null;

			if (p.getPreco() == null)
				preco = new EnPreco();
			else
				preco = p.getPreco();

			preco.setCodProduto(p.getCodigo());
			preco.setCodVendedor(precoForm.getCodVendedor());
			preco.setNomeTabelaVenda(precoForm.getNomeTabelaVenda());
			preco.setValorProduto(precoForm.getValorProduto());
			preco.setValorVendedor(precoForm.getValorVendedor());
			EnPreco precoSalvo = daoPreco.salvaOuAtualiza(preco);
			p.setCodPreco(precoSalvo.getCodigo());
			boProduto.salvaOuAtualiza(p);
		}
	}

	public List<EnPreco> listarTodosSemLazyVendedorEProdutos() {
		return daoPreco.listarTodosSemLazyVendedorEProdutos();
	}

}
