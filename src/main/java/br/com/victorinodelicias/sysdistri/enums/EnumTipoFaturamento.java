package br.com.victorinodelicias.sysdistri.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

public enum EnumTipoFaturamento {

	MENSAL(1, "Mensal"), QUINZENAL(2, "Quinzenal"), SEMANAL(3, "Semanal");

	private Integer codigo;
	private String descricao;

	private EnumTipoFaturamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumTipoFaturamento getValue(Integer codigo) {
		return values()[--codigo];
	}

	public static List<EnumTipoFaturamento> getValues() {
		return new ArrayList<EnumTipoFaturamento>(Arrays.asList(EnumTipoFaturamento.values()));
	}

}
