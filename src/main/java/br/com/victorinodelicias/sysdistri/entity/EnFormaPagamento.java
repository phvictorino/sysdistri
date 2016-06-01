package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_forma_pagamento database table.
 * 
 */
@Entity
@Table(name = "tb_forma_pagamento")
@NamedQuery(name = "EnFormaPagamento.findAll", query = "SELECT t FROM EnFormaPagamento t")
public class EnFormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codfpag", unique = true)
	private Integer codigo;

	@Column(name = "desfpga")
	private String descricao;

	// bi-directional many-to-one association to TbPedido
	@OneToMany(mappedBy = "formaPagamento")
	private List<EnPedido> listaPedidos;

}