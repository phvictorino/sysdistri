package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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

}