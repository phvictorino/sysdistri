package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.victorinodelicias.sysdistri.enums.EnumStatus;

/**
 * The persistent class for the tb_rotas database table.
 * 
 */
@Entity
@Table(name = "tb_rotas")
@NamedQuery(name = "EnRota.findAll", query = "SELECT t FROM EnRota t")
public class EnRota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rotas_seq")
	@SequenceGenerator(name = "rotas_seq", sequenceName = "rotas_sequence", allocationSize = 1)
	@Column(name = "codrot", unique = true)
	private Integer codigo;

	@Column(name = "desrot")
	private String descricao;

	@Column(name = "statrot")
	private Integer status;

	@Column(name = "codven")
	private Integer codVendedor;

	// bi-directional many-to-one association to TbEnderecoCliente
	@OneToMany(mappedBy = "rota")
	private List<EnEnderecoCliente> listaEnderecosCliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codven", insertable = false, updatable = false)
	private EnVendedor vendedor;

	public EnumStatus getEnumStatus() {
		return EnumStatus.getStatus(status);
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<EnEnderecoCliente> getListaEnderecosCliente() {
		return listaEnderecosCliente;
	}

	public void setListaEnderecosCliente(List<EnEnderecoCliente> listaEnderecosCliente) {
		this.listaEnderecosCliente = listaEnderecosCliente;
	}

	public Integer getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
	}

	public EnVendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(EnVendedor vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codVendedor == null) ? 0 : codVendedor.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((listaEnderecosCliente == null) ? 0 : listaEnderecosCliente.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
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
		EnRota other = (EnRota) obj;
		if (codVendedor == null) {
			if (other.codVendedor != null)
				return false;
		} else if (!codVendedor.equals(other.codVendedor))
			return false;
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
		if (listaEnderecosCliente == null) {
			if (other.listaEnderecosCliente != null)
				return false;
		} else if (!listaEnderecosCliente.equals(other.listaEnderecosCliente))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

}