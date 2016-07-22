package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Email;

import java.util.List;

/**
 * The persistent class for the tb_clientes database table.
 * 
 */
@Entity
@Table(name = "tb_clientes")
@NamedQuery(name = "EnCliente.findAll", query = "SELECT t FROM EnCliente t")
public class EnCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codcli", unique = true)
	private Integer codigo;

	@Column(name = "celcli")
	private String celular;

	@Column(name = "cnpjcpfcli")
	private String cnpjCpf;

	@Email(message = "Email não é válido.")
	@Column(name = "emacli")
	private String email;

	@Max(value = 18)
	@Column(name = "insestrgcli")
	private String inscricaoEstadual;

	@Column(name = "nomcli")
	private String nome;

	@Column(name = "tabven")
	private Integer tabelaVenda;

	@Column(name = "telcli")
	private String telefone;

	@Column(name = "tipcli")
	private String tipo;

	@Column(name = "codven")
	private Integer codVendedor;

	// bi-directional many-to-one association to TbVendedore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codven", insertable = false, updatable = false)
	private EnVendedor vendedor;

	// bi-directional many-to-one association to TbContasPr
	@OneToMany(mappedBy = "cliente")
	private List<EnContasPr> listaContas;

	// bi-directional many-to-one association to TbEnderecoCliente
	@OneToMany(mappedBy = "cliente")
	private List<EnEnderecoCliente> listaEnderecosCliente;

	// bi-directional many-to-one association to TbPedido
	@OneToMany(mappedBy = "cliente")
	private List<EnPedido> listaPedidos;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTabelaVenda() {
		return tabelaVenda;
	}

	public void setTabelaVenda(Integer tabelaVenda) {
		this.tabelaVenda = tabelaVenda;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public List<EnContasPr> getListaContas() {
		return listaContas;
	}

	public void setListaContas(List<EnContasPr> listaContas) {
		this.listaContas = listaContas;
	}

	public List<EnEnderecoCliente> getListaEnderecosCliente() {
		return listaEnderecosCliente;
	}

	public void setListaEnderecosCliente(List<EnEnderecoCliente> listaEnderecosCliente) {
		this.listaEnderecosCliente = listaEnderecosCliente;
	}

	public List<EnPedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<EnPedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

}