package br.com.victorinodelicias.dto;

public class DtoProduto {

	public DtoProduto(Integer codigo, String nome, Integer codAtalho) {
		this.codigo = codigo;
		this.nome = nome;
		this.codAtalho = codAtalho;
	}

	private Integer codigo;
	private String nome;
	private Integer codAtalho;

	// private BigDecimal
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodAtalho() {
		return codAtalho;
	}

	public void setCodAtalho(Integer codAtalho) {
		this.codAtalho = codAtalho;
	}

}
