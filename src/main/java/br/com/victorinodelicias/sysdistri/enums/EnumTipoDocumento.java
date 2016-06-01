package br.com.victorinodelicias.sysdistri.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EnumTipoDocumento {

	BOLETO(1, "Boleto"), NF(2, "Nota fiscal"), RECIBO(3, "Recibo");

	private Integer codigo;
	private String descricao;

	private EnumTipoDocumento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumTipoDocumento getValue(Integer codigo) {
		return values()[--codigo];
	}

	public static List<EnumTipoDocumento> getValues() {
		return new ArrayList<EnumTipoDocumento>(Arrays.asList(EnumTipoDocumento.values()));
	}

}
