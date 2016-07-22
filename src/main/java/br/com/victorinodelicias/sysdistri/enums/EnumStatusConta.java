package br.com.victorinodelicias.sysdistri.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum EnumStatusConta {

	AGUARDANDO_PAGAMENTO((char) 1, "Aguardando pagamento"), EM_ANALISE((char) 2, "Em Análise"), PAGO((char) 3,
			"Pago"), ATRASADO((char) 4, "Atrasado"), CANCELADO((char) 5, "Cancelado");

	private Character codigo;
	private String descricao;

	private EnumStatusConta(Character codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Character getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumStatusConta getValue(Character codigo) {
		return values()[--codigo];
	}

	public static List<EnumStatusConta> getValues() {
		return new ArrayList<EnumStatusConta>(Arrays.asList(values()));
	}

}
