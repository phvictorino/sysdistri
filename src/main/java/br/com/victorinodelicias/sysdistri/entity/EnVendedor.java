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

import br.com.victorinodelicias.sysdistri.enums.EnumStatus;
import br.com.victorinodelicias.sysdistri.enums.EnumTipoFaturamento;

/**
 * The persistent class for the tb_vendedores database table.
 * 
 */
@Entity
@Table(name = "tb_vendedores")
@NamedQuery(name = "EnVendedor.findAll", query = "SELECT t FROM EnVendedor t")
public class EnVendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codven", unique = true)
	private Integer codigo;

	@Column(name = "nomven")
	private String nome;

	@Column(name = "tipfat")
	private Integer tipoFaturamento;

	@Column(name = "statven", columnDefinition = "integer default 1")
	private Integer status;

	// bi-directional many-to-one association to TbCliente
	@OneToMany(mappedBy = "vendedor")
	private List<EnCliente> listaClientes;

	// bi-directional many-to-one association to TbPedido
	@OneToMany(mappedBy = "vendedor")
	private List<EnPedido> listaPedidos;

	// bi-directional many-to-one association to TbPreco
	@OneToMany(mappedBy = "vendedor")
	private List<EnPreco> listaPrecos;

	// bi-directional many-to-one association to TbContasPr
	@OneToMany(mappedBy = "vendedor")
	private List<EnContasPr> listaContas;

	public EnumTipoFaturamento getEnumTipoFaturamento() {
		return EnumTipoFaturamento.getValue(tipoFaturamento);
	}

	public EnumStatus getEnumStatus() {
		return EnumStatus.getStatus(status);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTipoFaturamento() {
		return tipoFaturamento;
	}

	public void setTipoFaturamento(Integer tipoFaturamento) {
		this.tipoFaturamento = tipoFaturamento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<EnCliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<EnCliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<EnPedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<EnPedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<EnPreco> getListaPrecos() {
		return listaPrecos;
	}

	public void setListaPrecos(List<EnPreco> listaPrecos) {
		this.listaPrecos = listaPrecos;
	}

	public List<EnContasPr> getListaContas() {
		return listaContas;
	}

	public void setListaContas(List<EnContasPr> listaContas) {
		this.listaContas = listaContas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((listaClientes == null) ? 0 : listaClientes.hashCode());
		result = prime * result + ((listaContas == null) ? 0 : listaContas.hashCode());
		result = prime * result + ((listaPedidos == null) ? 0 : listaPedidos.hashCode());
		result = prime * result + ((listaPrecos == null) ? 0 : listaPrecos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipoFaturamento == null) ? 0 : tipoFaturamento.hashCode());
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
		EnVendedor other = (EnVendedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (listaClientes == null) {
			if (other.listaClientes != null)
				return false;
		} else if (!listaClientes.equals(other.listaClientes))
			return false;
		if (listaContas == null) {
			if (other.listaContas != null)
				return false;
		} else if (!listaContas.equals(other.listaContas))
			return false;
		if (listaPedidos == null) {
			if (other.listaPedidos != null)
				return false;
		} else if (!listaPedidos.equals(other.listaPedidos))
			return false;
		if (listaPrecos == null) {
			if (other.listaPrecos != null)
				return false;
		} else if (!listaPrecos.equals(other.listaPrecos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoFaturamento == null) {
			if (other.tipoFaturamento != null)
				return false;
		} else if (!tipoFaturamento.equals(other.tipoFaturamento))
			return false;
		return true;
	}
}