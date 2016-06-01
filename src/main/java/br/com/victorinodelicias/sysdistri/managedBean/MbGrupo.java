package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.victorinodelicias.sysdistri.bussiness.BoGrupo;
import br.com.victorinodelicias.sysdistri.entity.EnGrupo;

@Named
@ViewScoped
public class MbGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BoGrupo boGrupo;

	public void testar() {
		EnGrupo obj = new EnGrupo();

		obj.setDescricao("Grupo teste.");

		EnGrupo objSalvo = boGrupo.salvaOuAtualiza(obj);

	}

}
