package com.elemaxelev.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFantasia;
	private String endereco;
	private Long numero;
	private String bairro;
	private String horarioFuncionamento;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;

	// utilizado Set para garantir que não haja
	// insumos repetidos para um determinado fornecedor
	@JsonIgnore
	@OneToMany(mappedBy = "id.fornecedor")
	private Set<InsumoFornecedor> insumosFornecedor = new HashSet<>();

	public Fornecedor(Long id, String nomeFantasia, String endereco, Long numero, String bairro,
			String horarioFuncionamento, Cidade cidade) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.horarioFuncionamento = horarioFuncionamento;
		this.cidade = cidade;
	}

	public Fornecedor() {

	}

	public Set<InsumoFornecedor> getInsumosFornecedor() {
		return insumosFornecedor;
	}

	public void setInsumosFornecedor(Set<InsumoFornecedor> insumosFornecedor) {
		this.insumosFornecedor = insumosFornecedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
