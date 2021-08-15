package com.elemaxelev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elemaxelev.domain.Fornecedor;
import com.elemaxelev.exceptions.services.ObjectNotFoundExceptionPersonalized;
import com.elemaxelev.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;

	public List<Fornecedor> findAll() {
		return repo.findAll();
	}

	public Fornecedor findById(Long pId) {

		Optional<Fornecedor> obj = repo.findById(pId);

		return obj.orElseThrow(() -> new ObjectNotFoundExceptionPersonalized(
				"Objeto não encontrado! Id: " + pId + ", Tipo: " + Fornecedor.class.getName()));
	}

}
