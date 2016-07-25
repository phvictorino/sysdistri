package br.com.victorinodelicias.dto;

public class DtoCliente extends DtoPessoa {

	public DtoCliente(Integer id, String nome, String telefone, String nomeVendedor) {
		super(id, nome);
		this.nomeVendedor = nomeVendedor;
		this.telefone = telefone;
	}

	private String nomeVendedor;
	private String telefone;

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
