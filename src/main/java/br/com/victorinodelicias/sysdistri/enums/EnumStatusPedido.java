package br.com.victorinodelicias.sysdistri.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumStatusPedido {

	AGUARDANDO_CONFIRMACAO(0, "Aguardando confirmação"), CONFIRMADO(1, "Confirmado"), SEPARACAO(2,
			"Em separação"), TRANSPORTE(3, "Em transporte"), ENTREGUE(4, "Entregue"), CANCELADO(5, "Cancelado");

	private Integer codigo;
	private String descricao;

	private EnumStatusPedido(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

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

	public EnumStatusPedido getEnum(Integer codigo) {
		return values()[--codigo];
	}

	public List<EnumStatusPedido> getValues() {
		return Arrays.asList(values());
	}

}
