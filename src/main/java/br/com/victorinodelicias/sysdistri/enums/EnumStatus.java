package br.com.victorinodelicias.sysdistri.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumStatus {

	INATIVO(0, "Inativo"), ATIVO(1, "Ativo");

	private EnumStatus(Integer codigo, String descricao) {
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

	public static EnumStatus getStatus(Integer codigo) {
		for (EnumStatus e : values()) {
			if (e.getCodigo().intValue() == codigo.intValue())
				return e;
		}
		return null;
	}

	public static List<EnumStatus> getValues() {
		return Arrays.asList(values());
	}

}
