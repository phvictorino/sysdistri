package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the tb_produtos_dos_pedidos database table.
 * 
 */
@Entity
@Table(name = "tb_produtos_dos_pedidos")
@NamedQuery(name = "EnProdutosDosPedido.findAll", query = "SELECT t FROM EnProdutosDosPedido t")
public class EnProdutosDosPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_pedidos_seq")
	@SequenceGenerator(name = "produtos_pedidos_seq", sequenceName = "produtos_pedidos_sequence", allocationSize = 1)
	@Column(name = "codpped", unique = true)
	private Integer codigo;

	@Column(name = "qtdpped")
	private BigDecimal quantidade;

	@Column(name = "stotpped")
	private BigDecimal subtotal;

	@Column(name = "numped")
	private Integer codPedido;

	@Column(name = "codprod")
	private Integer codProduto;

	// bi-directional many-to-one association to TbPedido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "numped", insertable = false, updatable = false)
	private EnPedido pedido;

	// bi-directional many-to-one association to TbProduto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codprod", insertable = false, updatable = false)
	private EnProduto produto;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public EnPedido getPedido() {
		return pedido;
	}

	public void setPedido(EnPedido pedido) {
		this.pedido = pedido;
	}

	public EnProduto getProduto() {
		return produto;
	}

	public void setProduto(EnProduto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPedido == null) ? 0 : codPedido.hashCode());
		result = prime * result + ((codProduto == null) ? 0 : codProduto.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((subtotal == null) ? 0 : subtotal.hashCode());
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
		EnProdutosDosPedido other = (EnProdutosDosPedido) obj;
		if (codPedido == null) {
			if (other.codPedido != null)
				return false;
		} else if (!codPedido.equals(other.codPedido))
			return false;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (subtotal == null) {
			if (other.subtotal != null)
				return false;
		} else if (!subtotal.equals(other.subtotal))
			return false;
		return true;
	}

}