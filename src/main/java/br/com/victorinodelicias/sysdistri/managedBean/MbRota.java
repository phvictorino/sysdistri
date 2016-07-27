package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;

import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoRota;
import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;
import br.com.victorinodelicias.sysdistri.entity.EnRota;
import br.com.victorinodelicias.sysdistri.enums.EnumStatus;
import br.com.victorinodelicias.sysdistri.util.UtilsFaces;

@Named
@ViewAccessScoped
public class MbRota implements Serializable {

	private static final long serialVersionUID = 1L;

	private EnRota rota;
	private List<EnRota> rotas;
	private List<DtoVendedor> vendedores;

	@Inject
	private BoRota boRota;

	@Inject
	private BoVendedor boVendedores;

	@PostConstruct
	public void init() {
		rota = new EnRota();
		rotas = boRota.listarTodosSemLazy();
		vendedores = boVendedores.buscarTodosPorDto();
	}

	public String novo() {
		rota = new EnRota();
		return "form.xhtml?faces-redirect=true";
	}

	public String editar(EnRota rotaSelecionada) {
		rota = rotaSelecionada;
		return "form.xhtml?faces-redirect=true";
	}

	public void salvar() {

		if (rota.getCodigo() == null)
			rota.setStatus(EnumStatus.ATIVO.getCodigo());

		EnRota objSalvo = boRota.salvaOuAtualiza(rota);

		if (objSalvo != null)
			UtilsFaces.adicionarMsgSucessoPadrao();
		else
			UtilsFaces.adicionarMsgErroPadrao();

		rotas = boRota.listarTodosSemLazy();

	}

	public void alterarStatus(EnRota rotaSelecionada) {
		if (rotaSelecionada.getEnumStatus().equals(EnumStatus.ATIVO))
			rotaSelecionada.setStatus(EnumStatus.INATIVO.getCodigo());
		else
			rotaSelecionada.setStatus(EnumStatus.ATIVO.getCodigo());

		boRota.salvaOuAtualiza(rotaSelecionada);

	}

	public void verDados(EnRota rotaSelecionada) {
		rota = boRota.buscarSemLazyClientes(rotaSelecionada.getCodigo());
		RequestContext.getCurrentInstance().execute("PF('dialogDados').show()");
	}

	public EnRota getRota() {
		return rota;
	}

	public void setRota(EnRota rota) {
		this.rota = rota;
	}

	public List<EnRota> getRotas() {
		return rotas;
	}

	public void setRotas(List<EnRota> rotas) {
		this.rotas = rotas;
	}

	public List<DtoVendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<DtoVendedor> vendedores) {
		this.vendedores = vendedores;
	}

}
