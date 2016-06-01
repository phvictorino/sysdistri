package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_cidades database table.
 * 
 */
@Entity
@Table(name = "tb_cidades")
@NamedQuery(name = "EnCidade.findAll", query = "SELECT c FROM EnCidade c")
public class EnCidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codcid", unique = true)
	private Integer codigo;

	@Column(name = "nomcid")
	private String nome;

	@Column(name = "siguf", columnDefinition = "bpchar(2)")
	private String siglaUf;

	// bi-directional many-to-one association to TbEnderecoCliente
	@OneToMany(mappedBy = "cidade")
	private List<EnEnderecoCliente> listaEnderecosCliente;

	// bi-directional many-to-one association to TbFornecedore
	@OneToMany(mappedBy = "cidade")
	private List<EnFornecedor> listaFornecedores;

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

	public String getSiglaUf() {
		return siglaUf;
	}

	public void setSiglaUf(String siglaUf) {
		this.siglaUf = siglaUf;
	}

	public List<EnEnderecoCliente> getListaEnderecosCliente() {
		return listaEnderecosCliente;
	}

	public void setListaEnderecosCliente(List<EnEnderecoCliente> listaEnderecosCliente) {
		this.listaEnderecosCliente = listaEnderecosCliente;
	}

	public List<EnFornecedor> getListaFornecedores() {
		return listaFornecedores;
	}

	public void setListaFornecedores(List<EnFornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((listaEnderecosCliente == null) ? 0 : listaEnderecosCliente.hashCode());
		result = prime * result + ((listaFornecedores == null) ? 0 : listaFornecedores.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((siglaUf == null) ? 0 : siglaUf.hashCode());
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
		EnCidade other = (EnCidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (listaEnderecosCliente == null) {
			if (other.listaEnderecosCliente != null)
				return false;
		} else if (!listaEnderecosCliente.equals(other.listaEnderecosCliente))
			return false;
		if (listaFornecedores == null) {
			if (other.listaFornecedores != null)
				return false;
		} else if (!listaFornecedores.equals(other.listaFornecedores))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (siglaUf == null) {
			if (other.siglaUf != null)
				return false;
		} else if (!siglaUf.equals(other.siglaUf))
			return false;
		return true;
	}

}