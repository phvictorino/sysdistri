package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_fornecedores database table.
 * 
 */
@Entity
@Table(name = "tb_fornecedores")
@NamedQuery(name = "EnFornecedor.findAll", query = "SELECT t FROM EnFornecedor t")
public class EnFornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codfor", unique = true)
	private Integer codigo;

	@Column(name = "baifor")
	private String bairro;

	@Column(name = "celfor")
	private String celular;

	@Column(name = "cepfor")
	private String cep;

	@Column(name = "cnpjfor")
	private String cnpj;

	@Column(name = "confor")
	private String contato;

	@Column(name = "emafor")
	private String email;

	@Column(name = "fatfor")
	private Integer tipoFaturamento;

	@Column(name = "insestfor")
	private String inscricaoEstadual;

	@Column(name = "logfor")
	private String logradouro;

	@Column(name = "nomfor")
	private String nome;

	@Column(name = "telfor")
	private String telefone;

	@Column(name = "codcid")
	private Integer codCidade;

	// bi-directional many-to-one association to TbContasPr
	@OneToMany(mappedBy = "fornecedor")
	private List<EnContasPr> listaContas;

	// bi-directional many-to-one association to Cidade
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codcid", insertable = false, updatable = false)
	private EnCidade cidade;

	// bi-directional many-to-one association to TbProduto
	@OneToMany(mappedBy = "fornecedor")
	private List<EnProduto> listaProdutos;

}