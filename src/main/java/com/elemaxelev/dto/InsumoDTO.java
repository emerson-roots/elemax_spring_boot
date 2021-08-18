package com.elemaxelev.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.elemaxelev.domain.Fornecedor;
import com.elemaxelev.domain.Insumo;
import com.elemaxelev.domain.enums.UnidadeMedida;

public class InsumoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private BigDecimal valorCompra;
	private UnidadeMedida unidadeMedida;
	private Double qtdPorEmbalagem;
	private BigDecimal valorPorUnidade;
	private LocalDate dataAtualizacao;

	private List<FornecedorDTOResumido> fornecedores;

	public InsumoDTO() {

	}

	public InsumoDTO(Insumo insumo) {
		id = insumo.getId();
		nome = insumo.getNome();
		valorCompra = insumo.getValorCompra();
		unidadeMedida = insumo.getUnidadeMedida();
		qtdPorEmbalagem = insumo.getQtdPorEmbalagem();
		valorPorUnidade = insumo.getValorPorUnidade();
		dataAtualizacao = insumo.getDataAtualizacao();
		fornecedores = listFornecedoresResumido(insumo);
	}

	private List<FornecedorDTOResumido> listFornecedoresResumido(Insumo insumo) {
		List<Fornecedor> fornecedores = insumo.getFornecedores();
		return fornecedores.stream().map(obj -> new FornecedorDTOResumido(obj)).collect(Collectors.toList());
	}

	public List<FornecedorDTOResumido> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorDTOResumido> fornecedores) {
		this.fornecedores = fornecedores;
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

}
