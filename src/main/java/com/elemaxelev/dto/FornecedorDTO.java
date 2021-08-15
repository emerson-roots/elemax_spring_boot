package com.elemaxelev.dto;

import java.io.Serializable;

import com.elemaxelev.domain.Fornecedor;

public class FornecedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeFantasia;
	private String endereco;
	private Long numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String horarioFuncionamento;

	public FornecedorDTO() {

	}

	public FornecedorDTO(Fornecedor fornecedor) {
		id = fornecedor.getId();
		nomeFantasia = fornecedor.getNomeFantasia();
		endereco = fornecedor.getEndereco();
		numero = fornecedor.getNumero();
		bairro = fornecedor.getBairro();
		cidade = fornecedor.getCidade().getNome();
		estado = fornecedor.getCidade().getEstado().getNome();
		horarioFuncionamento = fornecedor.getHorarioFuncionamento();

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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

}
