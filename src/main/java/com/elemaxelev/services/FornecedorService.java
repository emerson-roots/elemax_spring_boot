package com.elemaxelev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elemaxelev.domain.Fornecedor;
import com.elemaxelev.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;

	public List<Fornecedor> findAll() {
		return repo.findAll();
	}

}
