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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forma_pagamento_seq")
	@SequenceGenerator(name = "forma_pagamento_seq", sequenceName = "forma_pagamento_sequence", allocationSize = 1)
	@Column(name = "codfpag", unique = true)
	private Integer codigo;

	@Column(name = "desfpga")
	private String descricao;

	// bi-directional many-to-one association to TbPedido
	@OneToMany(mappedBy = "formaPagamento")
	private List<EnPedido> listaPedidos;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<EnPedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<EnPedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

}