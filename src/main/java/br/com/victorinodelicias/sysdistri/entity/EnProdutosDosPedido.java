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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codpped", unique = true)
	private Integer codigo;

	@Column(name = "qtdpped")
	private BigDecimal quantidade;

	@Column(name = "stapped")
	private String status;

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

}