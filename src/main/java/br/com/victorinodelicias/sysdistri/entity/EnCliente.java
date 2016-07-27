package br.com.victorinodelicias.sysdistri.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

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

	@Column(name = "insestrgcli")
	private String inscricaoEstadual;

	@Column(name = "nomcli")
	private String nome;

	@Column(name = "tabven")
	private Integer tabelaVenda;

	@Column(name = "telcli")
	private String telefone;

	@Column(name = "tipcli")
	private Integer tipo;

	@Column(name = "statcli", columnDefinition = "integer default 1")
	private Integer status;

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
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cnpjCpf == null) ? 0 : cnpjCpf.hashCode());
		result = prime * result + ((codVendedor == null) ? 0 : codVendedor.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((inscricaoEstadual == null) ? 0 : inscricaoEstadual.hashCode());
		result = prime * result + ((listaContas == null) ? 0 : listaContas.hashCode());
		result = prime * result + ((listaEnderecosCliente == null) ? 0 : listaEnderecosCliente.hashCode());
		result = prime * result + ((listaPedidos == null) ? 0 : listaPedidos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tabelaVenda == null) ? 0 : tabelaVenda.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
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
		EnCliente other = (EnCliente) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cnpjCpf == null) {
			if (other.cnpjCpf != null)
				return false;
		} else if (!cnpjCpf.equals(other.cnpjCpf))
			return false;
		if (codVendedor == null) {
			if (other.codVendedor != null)
				return false;
		} else if (!codVendedor.equals(other.codVendedor))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (inscricaoEstadual == null) {
			if (other.inscricaoEstadual != null)
				return false;
		} else if (!inscricaoEstadual.equals(other.inscricaoEstadual))
			return false;
		if (listaContas == null) {
			if (other.listaContas != null)
				return false;
		} else if (!listaContas.equals(other.listaContas))
			return false;
		if (listaEnderecosCliente == null) {
			if (other.listaEnderecosCliente != null)
				return false;
		} else if (!listaEnderecosCliente.equals(other.listaEnderecosCliente))
			return false;
		if (listaPedidos == null) {
			if (other.listaPedidos != null)
				return false;
		} else if (!listaPedidos.equals(other.listaPedidos))
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
		if (tabelaVenda == null) {
			if (other.tabelaVenda != null)
				return false;
		} else if (!tabelaVenda.equals(other.tabelaVenda))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}

}