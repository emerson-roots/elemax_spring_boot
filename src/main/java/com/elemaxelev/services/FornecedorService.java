package com.elemaxelev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.elemaxelev.domain.Fornecedor;
import com.elemaxelev.exceptions.services.DataIntegrityExceptionPersonalized;
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

	public Fornecedor insert(Fornecedor obj) {

		obj.setId(null);

		Fornecedor objByNome = repo.findByNomeFantasia(obj.getNomeFantasia());

		// verifica se ja existe um objeto cadastrado com o mesmo nome
		if (objByNome == null) {
			obj = repo.save(obj);
			return obj;
		} else {
			throw new DataIntegrityExceptionPersonalized(
					"Já existe um fornecedor '" + objByNome.getNomeFantasia() + "' cadastrado.");
		}
	}

	public Fornecedor update(Fornecedor obj) {
		Fornecedor newObj = findById(obj.getId());
		Fornecedor objByNome = repo.findByNomeFantasia(obj.getNomeFantasia());

		if (objByNome == null) {
			updateData(newObj, obj);
			return repo.save(newObj);
		} else {
			throw new DataIntegrityExceptionPersonalized(
					"Já existe um fornecedor '" + objByNome.getNomeFantasia() + "' cadastrado.");
		}
	}

	private void updateData(Fornecedor newObj, Fornecedor obj) {
		newObj.setNomeFantasia(obj.getNomeFantasia());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNumero(obj.getNumero());
		newObj.setBairro(obj.getBairro());
		newObj.setHorarioFuncionamento(obj.getHorarioFuncionamento());
		newObj.setCidade(obj.getCidade());
	}
	
	public void delete(Long id) {
		findById(id);
		
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExceptionPersonalized("Não é possível excluir porque há registros relacionados.");
		}
	}

}
