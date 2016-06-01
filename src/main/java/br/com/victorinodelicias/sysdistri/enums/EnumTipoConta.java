package br.com.victorinodelicias.sysdistri.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EnumTipoConta {

	CONTA_RECEBER(1, "Conta a Receber", "R"), CONTA_PAGAR(2, "Conta a pagar", "P");

	private Integer codigo;
	private String descricao;
	private String tag;

	private EnumTipoConta(Integer codigo, String descricao, String tag) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.tag = tag;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getTag() {
		return tag;
	}

	public static EnumTipoConta getValue(Integer codigo) {
		return values()[--codigo];
	}

	public static List<EnumTipoConta> getValues() {
		return new ArrayList<EnumTipoConta>(Arrays.asList(EnumTipoConta.values()));
	}

}
