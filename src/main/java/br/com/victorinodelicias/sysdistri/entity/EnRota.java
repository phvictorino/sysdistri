package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_rotas database table.
 * 
 */
@Entity
@Table(name = "tb_rotas")
@NamedQuery(name = "EnRota.findAll", query = "SELECT t FROM EnRota t")
public class EnRota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codrot", unique = true)
	private Integer codigo;

	@Column(name = "desrot")
	private String descricao;

	// bi-directional many-to-one association to TbEnderecoCliente
	@OneToMany(mappedBy = "rota")
	private List<EnEnderecoCliente> listaEnderecosCliente;

}