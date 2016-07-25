package br.com.victorinodelicias.sysdistri.enums;

public enum EnumStatusEndereco {

	INATIVO(0, "Inativo"), ATIVO(1, "Ativo");

	private EnumStatusEndereco(Integer codigo, String descricao) {
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

}
