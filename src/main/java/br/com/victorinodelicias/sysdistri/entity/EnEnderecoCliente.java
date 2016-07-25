package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tb_endereco_clientes database table.
 * 
 */
@Entity
@Table(name = "tb_endereco_clientes")
@NamedQuery(name = "EnEnderecoCliente.findAll", query = "SELECT t FROM EnEnderecoCliente t")
public class EnEnderecoCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codecli", unique = true)
	private Integer codigo;

	@Column(name = "baicli")
	private String bairro;

	@Column(name = "cepcli")
	private String cep;

	@Column(name = "fg_atucli")
	private Integer enderecoAtual;

	@Column(name = "logcli")
	private String logradouro;

	@Column(name = "codcid")
	private Integer codCidade;

	@Column(name = "codcli")
	private Integer codCliente;

	@Column(name = "codrot")
	private Integer codRota;

	// bi-directional many-to-one association to Cidade
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "codcid", insertable = false, updatable = false)
	private EnCidade cidade;

	// bi-directional many-to-one association to TbCliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codcli", insertable = false, updatable = false)
	private EnCliente cliente;

	// bi-directional many-to-one association to TbRota
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codrot", insertable = false, updatable = false)
	private EnRota rota;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getEnderecoAtual() {
		return enderecoAtual;
	}

	public void setEnderecoAtual(Integer enderecoAtual) {
		this.enderecoAtual = enderecoAtual;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(Integer codCidade) {
		this.codCidade = codCidade;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodRota() {
		return codRota;
	}

	public void setCodRota(Integer codRota) {
		this.codRota = codRota;
	}

	public EnCidade getCidade() {
		return cidade;
	}

	public void setCidade(EnCidade cidade) {
		this.cidade = cidade;
	}

	public EnCliente getCliente() {
		return cliente;
	}

	public void setCliente(EnCliente cliente) {
		this.cliente = cliente;
	}

	public EnRota getRota() {
		return rota;
	}

	public void setRota(EnRota rota) {
		this.rota = rota;
	}

}