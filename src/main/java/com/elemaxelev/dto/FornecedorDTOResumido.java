package com.elemaxelev.dto;

import java.io.Serializable;

import com.elemaxelev.domain.Fornecedor;

public class FornecedorDTOResumido implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeFantasia;

	public FornecedorDTOResumido() {

	}

	public FornecedorDTOResumido(Fornecedor fornecedor) {
		id = fornecedor.getId();
		nomeFantasia = fornecedor.getNomeFantasia();
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

}
