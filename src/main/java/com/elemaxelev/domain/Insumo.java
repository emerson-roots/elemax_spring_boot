package com.elemaxelev.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	@OneToMany(mappedBy = "insumo")
	private List<InsumoFornecedor> insumosFornecedor = new ArrayList<>();

	public Insumo(Long id, String nome, BigDecimal valorCompra, UnidadeMedida unidadeMedida, Double qtdPorEmbalagem,
			BigDecimal valorPorUnidade, LocalDate dataAtualizacao, List<InsumoFornecedor> insumosFornecedor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorCompra = valorCompra;
		this.unidadeMedida = unidadeMedida;
		this.qtdPorEmbalagem = qtdPorEmbalagem;
		this.valorPorUnidade = valorPorUnidade;
		this.dataAtualizacao = dataAtualizacao;
		this.insumosFornecedor = insumosFornecedor;
	}

	public Insumo() {

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

	public List<InsumoFornecedor> getInsumosFornecedor() {
		return insumosFornecedor;
	}

	public void setInsumosFornecedor(List<InsumoFornecedor> insumosFornecedor) {
		this.insumosFornecedor = insumosFornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insumosFornecedor == null) ? 0 : insumosFornecedor.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((qtdPorEmbalagem == null) ? 0 : qtdPorEmbalagem.hashCode());
		result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
		result = prime * result + ((valorCompra == null) ? 0 : valorCompra.hashCode());
		result = prime * result + ((valorPorUnidade == null) ? 0 : valorPorUnidade.hashCode());
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
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insumosFornecedor == null) {
			if (other.insumosFornecedor != null)
				return false;
		} else if (!insumosFornecedor.equals(other.insumosFornecedor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (qtdPorEmbalagem == null) {
			if (other.qtdPorEmbalagem != null)
				return false;
		} else if (!qtdPorEmbalagem.equals(other.qtdPorEmbalagem))
			return false;
		if (unidadeMedida != other.unidadeMedida)
			return false;
		if (valorCompra == null) {
			if (other.valorCompra != null)
				return false;
		} else if (!valorCompra.equals(other.valorCompra))
			return false;
		if (valorPorUnidade == null) {
			if (other.valorPorUnidade != null)
				return false;
		} else if (!valorPorUnidade.equals(other.valorPorUnidade))
			return false;
		return true;
	}

}
