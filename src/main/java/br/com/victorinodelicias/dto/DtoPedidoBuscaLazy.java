package br.com.victorinodelicias.dto;

public class DtoPedidoBuscaLazy {

	private int primeiroRegistro;
	private int qtdRegistros;
	private String atributoOrdenacao;
	private boolean ascendente;

	public int getPrimeiroRegistro() {
		return primeiroRegistro;
	}

	public void setPrimeiroRegistro(int primeiroRegistro) {
		this.primeiroRegistro = primeiroRegistro;
	}

	public int getQtdRegistros() {
		return qtdRegistros;
	}

	public void setQtdRegistros(int qtdRegistros) {
		this.qtdRegistros = qtdRegistros;
	}

	public String getAtributoOrdenacao() {
		return atributoOrdenacao;
	}

	public void setAtributoOrdenacao(String atributoOrdenacao) {
		this.atributoOrdenacao = atributoOrdenacao;
	}

	public boolean isAscendente() {
		return ascendente;
	}

	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}

}
