package br.com.victorinodelicias.dto;

import java.io.Serializable;

public class DtoProduto implements Serializable {
	
	private static final long serialVersionUID = 6239149925533994729L;

	public DtoProduto(Integer codigo, String nome, Integer codAtalho) {
		this.codigo = codigo;
		this.nome = nome;
		this.codAtalho = codAtalho;
	}

	private Integer codigo;
	private String nome;
	private Integer codAtalho;
	
	public DtoProduto() {
		super();
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAtalho == null) ? 0 : codAtalho.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoProduto other = (DtoProduto) obj;
		if (codAtalho == null) {
			if (other.codAtalho != null)
				return false;
		} else if (!codAtalho.equals(other.codAtalho))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}

}
