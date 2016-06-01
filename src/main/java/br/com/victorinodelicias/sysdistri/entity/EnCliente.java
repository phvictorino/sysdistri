package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
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

	@Column(name = "emacli")
	private String email;

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

}