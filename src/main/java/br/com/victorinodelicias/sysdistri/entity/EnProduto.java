package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the tb_produtos database table.
 * 
 */
@Entity
@Table(name = "tb_produtos")
@NamedQuery(name = "EnProduto.findAll", query = "SELECT t FROM EnProduto t")
public class EnProduto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codprod", unique = true)
	private Integer codigo;

	@Column(name = "codgru")
	private Integer codGrupo;

	@Column(name = "coduni")
	private Integer codUnidade;

	@Temporal(TemporalType.DATE)
	@Column(name = "datucm")
	private Date dataUltimaCompra;

	@Temporal(TemporalType.DATE)
	@Column(name = "datuve")
	private Date dataUltimaVenda;

	@Column(name = "despro")
	private String descricao;

	@Column(name = "estmax")
	private BigDecimal estoqueMaximo;

	@Column(name = "estmin")
	private BigDecimal estoqueMinimo;

	@Column(name = "estpro")
	private BigDecimal estoqueAtual;

	@Column(name = "obsprod")
	private String observacao;

	@Column(name = "plucpro")
	private BigDecimal percentualLucro;

	@Column(name = "stapro")
	private String status;

	@Column(name = "vcompro")
	private BigDecimal valorCompra;

	@Column(name = "vvendprod")
	private BigDecimal valorVenda;

	@Column(name = "codfor")
	private Integer codForncedor;

	// bi-directional many-to-one association to TbPreco
	@OneToMany(mappedBy = "produto")
	private List<EnPreco> listaPrecos;

	// bi-directional many-to-one association to TbFornecedore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codfor", insertable = false, updatable = false)
	private EnFornecedor fornecedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coduni", insertable = false, updatable = false)
	private EnUnidade unidade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codgru", insertable = false, updatable = false)
	private EnGrupo grupo;

	// bi-directional many-to-one association to TbProdutosDosPedido
	@OneToMany(mappedBy = "produto")
	private List<EnProdutosDosPedido> listaProdutosPedidos;

}