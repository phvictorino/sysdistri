package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tb_pedidos database table.
 * 
 */
@Entity
@Table(name = "tb_pedidos")
@NamedQuery(name = "EnPedido.findAll", query = "SELECT t FROM EnPedido t")
public class EnPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_seq")
	@SequenceGenerator(name = "pedidos_seq", sequenceName = "pedidos_sequence", allocationSize = 1)
	@Column(name = "numped", unique = true)
	private Integer codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "datent")
	private Date dataEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name = "datped")
	private Date dataPedido;

	@Column(name = "obsped")
	private String observacao;

	@Column(name = "staped")
	private String status;

	@Column(name = "vtotped")
	private BigDecimal valorTotal;

	@Column(name = "codcli")
	private Integer codCliente;

	@Column(name = "codfpag")
	private Integer codFormaPagamento;

	@Column(name = "codven")
	private Integer codVendedor;

	// bi-directional many-to-one association to TbContasPr
	@OneToMany(mappedBy = "pedido")
	private List<EnContasPr> listaContas;

	// bi-directional many-to-one association to TbCliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codcli", insertable = false, updatable = false)
	private EnCliente cliente;

	// bi-directional many-to-one association to TbFormaPagamento
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codfpag", insertable = false, updatable = false)
	private EnFormaPagamento formaPagamento;

	// bi-directional many-to-one association to TbVendedore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codven", insertable = false, updatable = false)
	private EnVendedor vendedor;

	// bi-directional many-to-one association to TbProdutosDosPedido
	@OneToMany(mappedBy = "pedido")
	private List<EnProdutosDosPedido> listaProdutosPedido;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodFormaPagamento() {
		return codFormaPagamento;
	}

	public void setCodFormaPagamento(Integer codFormaPagamento) {
		this.codFormaPagamento = codFormaPagamento;
	}

	public Integer getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
	}

	public List<EnContasPr> getListaContas() {
		return listaContas;
	}

	public void setListaContas(List<EnContasPr> listaContas) {
		this.listaContas = listaContas;
	}

	public EnCliente getCliente() {
		return cliente;
	}

	public void setCliente(EnCliente cliente) {
		this.cliente = cliente;
	}

	public EnFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(EnFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public EnVendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(EnVendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<EnProdutosDosPedido> getListaProdutosPedido() {
		return listaProdutosPedido;
	}

	public void setListaProdutosPedido(List<EnProdutosDosPedido> listaProdutosPedido) {
		this.listaProdutosPedido = listaProdutosPedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
		result = prime * result + ((codFormaPagamento == null) ? 0 : codFormaPagamento.hashCode());
		result = prime * result + ((codVendedor == null) ? 0 : codVendedor.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result + ((dataPedido == null) ? 0 : dataPedido.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((listaContas == null) ? 0 : listaContas.hashCode());
		result = prime * result + ((listaProdutosPedido == null) ? 0 : listaProdutosPedido.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		EnPedido other = (EnPedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codCliente == null) {
			if (other.codCliente != null)
				return false;
		} else if (!codCliente.equals(other.codCliente))
			return false;
		if (codFormaPagamento == null) {
			if (other.codFormaPagamento != null)
				return false;
		} else if (!codFormaPagamento.equals(other.codFormaPagamento))
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
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (dataPedido == null) {
			if (other.dataPedido != null)
				return false;
		} else if (!dataPedido.equals(other.dataPedido))
			return false;
		if (formaPagamento == null) {
			if (other.formaPagamento != null)
				return false;
		} else if (!formaPagamento.equals(other.formaPagamento))
			return false;
		if (listaContas == null) {
			if (other.listaContas != null)
				return false;
		} else if (!listaContas.equals(other.listaContas))
			return false;
		if (listaProdutosPedido == null) {
			if (other.listaProdutosPedido != null)
				return false;
		} else if (!listaProdutosPedido.equals(other.listaProdutosPedido))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

}