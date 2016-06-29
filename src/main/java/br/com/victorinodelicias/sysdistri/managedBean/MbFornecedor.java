package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import br.com.victorinodelicias.sysdistri.entity.EnFornecedor;

@Named
@ViewAccessScoped
public class MbFornecedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EnFornecedor fornecedor;
	private List<EnFornecedor> listaFornecedor;	

	@PostConstruct
	public void init() {
		
	}
	
}
