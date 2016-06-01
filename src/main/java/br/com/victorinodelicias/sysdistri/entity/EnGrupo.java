package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tb_grupos database table.
 * 
 */
@Entity
@Table(name = "tb_grupos")
@NamedQuery(name = "EnGrupo.findAll", query = "SELECT t FROM EnGrupo t")
public class EnGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codgru", unique = true)
	private Integer codigo;

	@Column(name = "desgru")
	private String descricao;

	@OneToMany(mappedBy = "grupo")
	private List<EnProduto> listaProdutos;

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

	public List<EnProduto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<EnProduto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((listaProdutos == null) ? 0 : listaProdutos.hashCode());
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
		EnGrupo other = (EnGrupo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (listaProdutos == null) {
			if (other.listaProdutos != null)
				return false;
		} else if (!listaProdutos.equals(other.listaProdutos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return descricao;
	}

}