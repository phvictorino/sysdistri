package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.victorinodelicias.sysdistri.enums.EnumStatus;

/**
 * The persistent class for the tb_precos database table.
 * 
 */
@Entity
@Table(name = "tb_precos")
@NamedQuery(name = "EnPreco.findAll", query = "SELECT t FROM EnPreco t")
public class EnPreco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "precos_seq")
	@SequenceGenerator(name = "precos_seq", sequenceName = "precos_sequence", allocationSize = 1)
	@Column(name = "codpre", unique = true)
	private Integer codigo;

	@Column(name = "tabven")
	private String nomeTabelaVenda;

	@Column(name = "stattab")
	private Integer status;

	@Column(name = "vvendpre")
	private BigDecimal valorProduto;

	@Column(name = "vvendven")
	private BigDecimal valorVendedor;

	@Column(name = "codprod")
	private Integer codProduto;

	@Column(name = "codven")
	private Integer codVendedor;

	// bi-directional many-to-one association to TbProduto
	@OneToOne
	@JoinColumn(name = "codprod", insertable = false, updatable = false)
	private EnProduto produto;

	// bi-directional many-to-one association to TbVendedore
	@OneToOne
	@JoinColumn(name = "codven", insertable = false, updatable = false)
	private EnVendedor vendedor;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeTabelaVenda() {
		return nomeTabelaVenda;
	}

	public void setNomeTabelaVenda(String nomeTabelaVenda) {
		this.nomeTabelaVenda = nomeTabelaVenda;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public BigDecimal getValorVendedor() {
		return valorVendedor;
	}

	public void setValorVendedor(BigDecimal valorVendedor) {
		this.valorVendedor = valorVendedor;
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public Integer getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
	}

	public EnProduto getProduto() {
		return produto;
	}

	public void setProduto(EnProduto produto) {
		this.produto = produto;
	}

	public EnVendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(EnVendedor vendedor) {
		this.vendedor = vendedor;
	}

	public EnumStatus getEnumStatus() {
		return EnumStatus.getStatus(status);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProduto == null) ? 0 : codProduto.hashCode());
		result = prime * result + ((codVendedor == null) ? 0 : codVendedor.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nomeTabelaVenda == null) ? 0 : nomeTabelaVenda.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((valorProduto == null) ? 0 : valorProduto.hashCode());
		result = prime * result + ((valorVendedor == null) ? 0 : valorVendedor.hashCode());
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
		EnPreco other = (EnPreco) obj;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
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
		if (nomeTabelaVenda == null) {
			if (other.nomeTabelaVenda != null)
				return false;
		} else if (!nomeTabelaVenda.equals(other.nomeTabelaVenda))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (valorProduto == null) {
			if (other.valorProduto != null)
				return false;
		} else if (!valorProduto.equals(other.valorProduto))
			return false;
		if (valorVendedor == null) {
			if (other.valorVendedor != null)
				return false;
		} else if (!valorVendedor.equals(other.valorVendedor))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

}