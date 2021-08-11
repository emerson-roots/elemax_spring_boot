package com.elemaxelev.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "insumo_fornecedor")
public class InsumoFornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valorCompra;
	private String fabricante;
	private Double qtdPorEmbalagem;

	@ManyToOne
	@JoinColumn(name = "insumo_id")
	private Insumo insumo;

	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;

	public InsumoFornecedor(Long id, BigDecimal valorCompra, String fabricante, Double qtdPorEmbalagem, Insumo insumo,
			Fornecedor fornecedor) {
		super();
		this.id = id;
		this.valorCompra = valorCompra;
		this.fabricante = fabricante;
		this.qtdPorEmbalagem = qtdPorEmbalagem;
		this.insumo = insumo;
		this.fornecedor = fornecedor;
	}

	public InsumoFornecedor() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getQtdPorEmbalagem() {
		return qtdPorEmbalagem;
	}

	public void setQtdPorEmbalagem(Double qtdPorEmbalagem) {
		this.qtdPorEmbalagem = qtdPorEmbalagem;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
		result = prime * result + ((qtdPorEmbalagem == null) ? 0 : qtdPorEmbalagem.hashCode());
		result = prime * result + ((valorCompra == null) ? 0 : valorCompra.hashCode());
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
		InsumoFornecedor other = (InsumoFornecedor) obj;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (insumo == null) {
			if (other.insumo != null)
				return false;
		} else if (!insumo.equals(other.insumo))
			return false;
		if (qtdPorEmbalagem == null) {
			if (other.qtdPorEmbalagem != null)
				return false;
		} else if (!qtdPorEmbalagem.equals(other.qtdPorEmbalagem))
			return false;
		if (valorCompra == null) {
			if (other.valorCompra != null)
				return false;
		} else if (!valorCompra.equals(other.valorCompra))
			return false;
		return true;
	}

}
