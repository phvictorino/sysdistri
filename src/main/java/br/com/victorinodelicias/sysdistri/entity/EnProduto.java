package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

	@Min(value = 1)
	@Max(value = 100)
	@Column(name = "plucpro")
	private BigDecimal percentualLucro;

	@Column(name = "stapro")
	private String status;

	@Column(name = "vcompro")
	private BigDecimal valorCompra;

	@Column(name = "codfor")
	private Integer codForncedor;

	// bi-directional many-to-one association to TbPreco
	@OneToMany(mappedBy = "produto")
	private List<EnPreco> listaPrecos;

	// bi-directional many-to-one association to TbFornecedore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codfor", insertable = false, updatable = false)
	private EnFornecedor fornecedor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "coduni", insertable = false, updatable = false)
	private EnUnidade unidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codgru", insertable = false, updatable = false)
	private EnGrupo grupo;

	// bi-directional many-to-one association to TbProdutosDosPedido
	@OneToMany(mappedBy = "produto")
	private List<EnProdutosDosPedido> listaProdutosPedidos;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(Integer codGrupo) {
		this.codGrupo = codGrupo;
	}

	public Integer getCodUnidade() {
		return codUnidade;
	}

	public void setCodUnidade(Integer codUnidade) {
		this.codUnidade = codUnidade;
	}

	public Date getDataUltimaCompra() {
		return dataUltimaCompra;
	}

	public void setDataUltimaCompra(Date dataUltimaCompra) {
		this.dataUltimaCompra = dataUltimaCompra;
	}

	public Date getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	public void setDataUltimaVenda(Date dataUltimaVenda) {
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public BigDecimal getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public BigDecimal getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(BigDecimal estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getPercentualLucro() {
		return percentualLucro;
	}

	public void setPercentualLucro(BigDecimal percentualLucro) {
		this.percentualLucro = percentualLucro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Integer getCodForncedor() {
		return codForncedor;
	}

	public void setCodForncedor(Integer codForncedor) {
		this.codForncedor = codForncedor;
	}

	public List<EnPreco> getListaPrecos() {
		return listaPrecos;
	}

	public void setListaPrecos(List<EnPreco> listaPrecos) {
		this.listaPrecos = listaPrecos;
	}

	public EnFornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(EnFornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public EnUnidade getUnidade() {
		return unidade;
	}

	public void setUnidade(EnUnidade unidade) {
		this.unidade = unidade;
	}

	public EnGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(EnGrupo grupo) {
		this.grupo = grupo;
	}

	public List<EnProdutosDosPedido> getListaProdutosPedidos() {
		return listaProdutosPedidos;
	}

	public void setListaProdutosPedidos(List<EnProdutosDosPedido> listaProdutosPedidos) {
		this.listaProdutosPedidos = listaProdutosPedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codForncedor == null) ? 0 : codForncedor.hashCode());
		result = prime * result + ((codGrupo == null) ? 0 : codGrupo.hashCode());
		result = prime * result + ((codUnidade == null) ? 0 : codUnidade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataUltimaCompra == null) ? 0 : dataUltimaCompra.hashCode());
		result = prime * result + ((dataUltimaVenda == null) ? 0 : dataUltimaVenda.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estoqueAtual == null) ? 0 : estoqueAtual.hashCode());
		result = prime * result + ((estoqueMaximo == null) ? 0 : estoqueMaximo.hashCode());
		result = prime * result + ((estoqueMinimo == null) ? 0 : estoqueMinimo.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((listaPrecos == null) ? 0 : listaPrecos.hashCode());
		result = prime * result + ((listaProdutosPedidos == null) ? 0 : listaProdutosPedidos.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((percentualLucro == null) ? 0 : percentualLucro.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		result = prime * result + ((valorCompra == null) ? 0 : valorCompra.hashCode());
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
		EnProduto other = (EnProduto) obj;
		if (codForncedor == null) {
			if (other.codForncedor != null)
				return false;
		} else if (!codForncedor.equals(other.codForncedor))
			return false;
		if (codGrupo == null) {
			if (other.codGrupo != null)
				return false;
		} else if (!codGrupo.equals(other.codGrupo))
			return false;
		if (codUnidade == null) {
			if (other.codUnidade != null)
				return false;
		} else if (!codUnidade.equals(other.codUnidade))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataUltimaCompra == null) {
			if (other.dataUltimaCompra != null)
				return false;
		} else if (!dataUltimaCompra.equals(other.dataUltimaCompra))
			return false;
		if (dataUltimaVenda == null) {
			if (other.dataUltimaVenda != null)
				return false;
		} else if (!dataUltimaVenda.equals(other.dataUltimaVenda))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estoqueAtual == null) {
			if (other.estoqueAtual != null)
				return false;
		} else if (!estoqueAtual.equals(other.estoqueAtual))
			return false;
		if (estoqueMaximo == null) {
			if (other.estoqueMaximo != null)
				return false;
		} else if (!estoqueMaximo.equals(other.estoqueMaximo))
			return false;
		if (estoqueMinimo == null) {
			if (other.estoqueMinimo != null)
				return false;
		} else if (!estoqueMinimo.equals(other.estoqueMinimo))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (listaPrecos == null) {
			if (other.listaPrecos != null)
				return false;
		} else if (!listaPrecos.equals(other.listaPrecos))
			return false;
		if (listaProdutosPedidos == null) {
			if (other.listaProdutosPedidos != null)
				return false;
		} else if (!listaProdutosPedidos.equals(other.listaProdutosPedidos))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (percentualLucro == null) {
			if (other.percentualLucro != null)
				return false;
		} else if (!percentualLucro.equals(other.percentualLucro))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		if (valorCompra == null) {
			if (other.valorCompra != null)
				return false;
		} else if (!valorCompra.equals(other.valorCompra))
			return false;
		return true;
	}

}