package br.com.victorinodelicias.sysdistri.managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

@Named
@ViewAccessScoped
public class MbRota implements Serializable {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {

	}

}
