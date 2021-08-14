package com.elemaxelev.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.elemaxelev.domain.enums.UnidadeMedida;

@Entity
@Table(name = "insumo")
public class Insumo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal valorCompra;
	private UnidadeMedida unidadeMedida;
	private Double qtdPorEmbalagem;
	private BigDecimal valorPorUnidade;
	private LocalDate dataAtualizacao;
	
	@OneToMany(mappedBy = "id.insumo")
	private Set<InsumoFornecedor> insumosFornecedor = new HashSet<>();

	public Insumo() {

	}

	public Insumo(Long id, String nome, BigDecimal valorCompra, UnidadeMedida unidadeMedida, Double qtdPorEmbalagem,
			BigDecimal valorPorUnidade, LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorCompra = valorCompra;
		this.unidadeMedida = unidadeMedida;
		this.qtdPorEmbalagem = qtdPorEmbalagem;
		this.valorPorUnidade = valorPorUnidade;
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Fornecedor> getFornecedores(){
		List<Fornecedor> listaFornecedores = new ArrayList<>();
		for(InsumoFornecedor x: insumosFornecedor) {
			listaFornecedores.add(x.getFornecedor());
		}
		
		return listaFornecedores;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Double getQtdPorEmbalagem() {
		return qtdPorEmbalagem;
	}

	public void setQtdPorEmbalagem(Double qtdPorEmbalagem) {
		this.qtdPorEmbalagem = qtdPorEmbalagem;
	}

	public BigDecimal getValorPorUnidade() {
		return valorPorUnidade;
	}

	public void setValorPorUnidade(BigDecimal valorPorUnidade) {
		this.valorPorUnidade = valorPorUnidade;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
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
		Insumo other = (Insumo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
