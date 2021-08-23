package com.elemaxelev.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoFornecedores implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// ao utilizar uma classe auxiliar para chaves compostas
	// é necessário adaptar os construtores para receber as entidades compostas
	// e implementar getters e setters manualmente de forma adaptada também
	// 
	// os recursos da IDE não fazem isso
	@JsonIgnore
	@EmbeddedId
	private InsumoFornecedoresPK id = new InsumoFornecedoresPK();
	
	private BigDecimal valorCompra;
	private String fabricante;
	private Double qtdPorEmbalagem;
	
	public InsumoFornecedores() {

	}
	
	// contrutor adaptado para trabalhar em conjunto da chave composta InsumoFornecedorPK
	public InsumoFornecedores(Insumo insumo, Fornecedor fornecedor,  BigDecimal valorCompra, String fabricante, Double qtdPorEmbalagem) {
		super();
		id.setInsumo(insumo);
		id.setFornecedor(fornecedor);
		this.valorCompra = valorCompra;
		this.fabricante = fabricante;
		this.qtdPorEmbalagem = qtdPorEmbalagem;
	}
	
	@JsonIgnore
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

	public InsumoFornecedoresPK getId() {
		return id;
	}

	public void setId(InsumoFornecedoresPK id) {
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
		InsumoFornecedores other = (InsumoFornecedores) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
