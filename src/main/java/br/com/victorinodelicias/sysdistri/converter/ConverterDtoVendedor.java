package br.com.victorinodelicias.sysdistri.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.victorinodelicias.dto.DtoVendedor;
import br.com.victorinodelicias.sysdistri.bussiness.BoVendedor;

@SuppressWarnings("rawtypes")
@FacesConverter(value = "converterDtoVendedor", managed = true)
public class ConverterDtoVendedor implements Converter {

	@Inject
	private BoVendedor boVendedor;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		if (arg2 != null && !arg2.isEmpty())
			return boVendedor.buscarPorId(Integer.parseInt(arg2));
		else
			return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 != null) {
			DtoVendedor v = (DtoVendedor) arg2;
			return v.getId().toString();
		} else {
			return null;
		}

	}

}
