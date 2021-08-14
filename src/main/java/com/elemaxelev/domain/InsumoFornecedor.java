package com.elemaxelev.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "insumo_fornecedor")
public class InsumoFornecedor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// ao utilizar uma classe auxiliar para chaves compostas
	// é necessário adaptar os construtores para receber as entidades compostas
	// e implementar getters e setters manualmente de forma adaptada também
	// 
	// os recursos da IDE não fazem isso
	@EmbeddedId
	private InsumoFornecedorPK id = new InsumoFornecedorPK();
	
	private BigDecimal valorCompra;
	private String fabricante;
	private Double qtdPorEmbalagem;
	
	public InsumoFornecedor() {

	}
	
	// contrutor adaptado para trabalhar em conjunto da chave composta InsumoFornecedorPK
	public InsumoFornecedor(Insumo insumo, Fornecedor fornecedor,  BigDecimal valorCompra, String fabricante, Double qtdPorEmbalagem) {
		super();
		id.setInsumo(insumo);
		id.setFornecedor(fornecedor);
		this.valorCompra = valorCompra;
		this.fabricante = fabricante;
		this.qtdPorEmbalagem = qtdPorEmbalagem;
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}
	
	public void setInsumo(Insumo insumo) {
		id.setInsumo(insumo);
	}
	
	public Fornecedor getFornecedor() {
		return id.getFornecedor();
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		id.setFornecedor(fornecedor);
	}

	public InsumoFornecedorPK getId() {
		return id;
	}

	public void setId(InsumoFornecedorPK id) {
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
		InsumoFornecedor other = (InsumoFornecedor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
