package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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

	@Temporal(TemporalType.DATE)
	@Column(name = "datfim")
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name = "datini")
	private Date dataInicio;

	@Column(name = "tabven")
	private Integer nomeTabelaVenda;

	@Column(name = "vvendpre")
	private BigDecimal valorProduto;

	@Column(name = "vvendven")
	private BigDecimal valorVendedor;

	@Column(name = "codprod")
	private Integer codProduto;

	@Column(name = "codven")
	private Integer codVendedor;

	// bi-directional many-to-one association to TbProduto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codprod", insertable = false, updatable = false)
	private EnProduto produto;

	// bi-directional many-to-one association to TbVendedore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codven", insertable = false, updatable = false)
	private EnVendedor vendedor;

}