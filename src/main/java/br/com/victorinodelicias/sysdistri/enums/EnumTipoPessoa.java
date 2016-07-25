package br.com.victorinodelicias.sysdistri.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumTipoPessoa {

	FISICA(0, "Física"), JURIDICA(1, "Jurídica");

	private EnumTipoPessoa(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	private Integer codigo;
	private String descricao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static EnumTipoPessoa getEnum(Integer codigo) {
		return values()[--codigo];
	}
	
	public static List<EnumTipoPessoa> getValues() {
		return Arrays.asList(values());
	}

}
