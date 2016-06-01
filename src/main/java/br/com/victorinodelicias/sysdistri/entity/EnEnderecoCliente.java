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
	@ManyToOne(fetch = FetchType.LAZY)
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

}