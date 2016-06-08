package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.victorinodelicias.sysdistri.enums.EnumPessoa;
import br.com.victorinodelicias.sysdistri.enums.EnumStatusConta;
import br.com.victorinodelicias.sysdistri.enums.EnumTipoConta;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the tb_contas_pr database table.
 * 
 */
@Entity
@Table(name = "tb_contas_pr")
@NamedQuery(name = "EnContasPr.findAll", query = "SELECT t FROM EnContasPr t")
public class EnContasPr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codcpr", unique = true)
	private Integer codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "datccpr")
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name = "datpcpr")
	private Date dataPrevista;

	@Temporal(TemporalType.DATE)
	@Column(name = "datvcpr")
	private Date dataVencimento;

	@Column(name = "doccpr")
	private String docNumero;

	@Column(name = "doctip")
	private String docTipo;

	@Column(name = "obscpr")
	private String observacao;

	@Column(name = "stacpr")
	private Character status;

	@Column(name = "tipcpr")
	private Integer tipo;

	@Column(name = "vlrcpr")
	private BigDecimal valor;

	@Column(name = "codCli")
	private Integer codCliente;

	@Column(name = "codfor")
	private Integer codFornecedor;

	@Column(name = "codven")
	private Integer codVendedor;

	@Column(name = "numped")
	private Integer numPedido;

	// bi-directional many-to-one association to TbCliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codcli", insertable = false, updatable = false)
	private EnCliente cliente;

	// bi-directional many-to-one association to TbFornecedore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codfor", insertable = false, updatable = false)
	private EnFornecedor fornecedor;

	// bi-directional many-to-one association to TbVendedor
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codven", insertable = false, updatable = false)
	private EnVendedor vendedor;

	// bi-directional many-to-one association to TbPedido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "numped", insertable = false, updatable = false)
	private EnPedido pedido;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDocNumero() {
		return docNumero;
	}

	public void setDocNumero(String docNumero) {
		this.docNumero = docNumero;
	}

	public String getDocTipo() {
		return docTipo;
	}

	public void setDocTipo(String docTipo) {
		this.docTipo = docTipo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodFornecedor() {
		return codFornecedor;
	}

	public void setCodFornecedor(Integer codFornecedor) {
		this.codFornecedor = codFornecedor;
	}

	public Integer getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}

	public EnCliente getCliente() {
		return cliente;
	}

	public void setCliente(EnCliente cliente) {
		this.cliente = cliente;
	}

	public EnFornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(EnFornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public EnPedido getPedido() {
		return pedido;
	}

	public void setPedido(EnPedido pedido) {
		this.pedido = pedido;
	}

	public EnumTipoConta getTipoEnum() {
		return EnumTipoConta.getValue(this.tipo);
	}

	public EnumPessoa getTipoPessoa() {
		if (this.vendedor != null) {
			return EnumPessoa.VENDEDOR;
		} else if (this.cliente != null) {
			return EnumPessoa.CLIENTE;
		} else if (this.fornecedor != null) {
			return EnumPessoa.FORNECEDOR;
		} else {
			return null;
		}
	}

	public EnumStatusConta getStatusEnum() {
		return EnumStatusConta.getValue(status);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
		result = prime * result + ((codFornecedor == null) ? 0 : codFornecedor.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataPrevista == null) ? 0 : dataPrevista.hashCode());
		result = prime * result + ((dataVencimento == null) ? 0 : dataVencimento.hashCode());
		result = prime * result + ((docNumero == null) ? 0 : docNumero.hashCode());
		result = prime * result + ((docTipo == null) ? 0 : docTipo.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((numPedido == null) ? 0 : numPedido.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		EnContasPr other = (EnContasPr) obj;
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
		if (codFornecedor == null) {
			if (other.codFornecedor != null)
				return false;
		} else if (!codFornecedor.equals(other.codFornecedor))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataPrevista == null) {
			if (other.dataPrevista != null)
				return false;
		} else if (!dataPrevista.equals(other.dataPrevista))
			return false;
		if (dataVencimento == null) {
			if (other.dataVencimento != null)
				return false;
		} else if (!dataVencimento.equals(other.dataVencimento))
			return false;
		if (docNumero == null) {
			if (other.docNumero != null)
				return false;
		} else if (!docNumero.equals(other.docNumero))
			return false;
		if (docTipo == null) {
			if (other.docTipo != null)
				return false;
		} else if (!docTipo.equals(other.docTipo))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (numPedido == null) {
			if (other.numPedido != null)
				return false;
		} else if (!numPedido.equals(other.numPedido))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnContasPr [codigo=" + codigo + "]";
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

}