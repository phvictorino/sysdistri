package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tb_unidades database table.
 * 
 */
@Entity
@Table(name = "tb_unidades")
@NamedQuery(name = "EnUnidade.findAll", query = "SELECT t FROM EnUnidade t")
public class EnUnidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "coduni", unique = true)
	private Integer codigo;

	@Column(name = "desuni")
	private String descricao;

	@OneToMany(mappedBy = "unidade")
	private List<EnProduto> listaProdutos;
}