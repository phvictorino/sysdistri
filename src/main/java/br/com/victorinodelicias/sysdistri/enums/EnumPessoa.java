package br.com.victorinodelicias.sysdistri.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EnumPessoa {

	FORNECEDOR(1, "Fornecedor"), VENDEDOR(2, "Vendedor"), CLIENTE(3, "Cliente");

	private Integer codigo;
	private String descricao;

	private EnumPessoa(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumPessoa getValue(Integer codigo) {
		return values()[--codigo];
	}

	public static List<EnumPessoa> getValues() {
		return new ArrayList<EnumPessoa>(Arrays.asList(values()));
	}

}
