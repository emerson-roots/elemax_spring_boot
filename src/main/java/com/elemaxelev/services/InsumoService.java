package com.elemaxelev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.elemaxelev.domain.Insumo;
import com.elemaxelev.exceptions.services.DataIntegrityExceptionPersonalized;
import com.elemaxelev.exceptions.services.ObjectNotFoundExceptionPersonalized;
import com.elemaxelev.repositories.InsumoRepository;

@Service
public class InsumoService {

	@Autowired
	private InsumoRepository repo;

	public List<Insumo> findAll() {
		return repo.findAll();
	}

	public Insumo findById(Long pId) {

		Optional<Insumo> obj = repo.findById(pId);

		return obj.orElseThrow(() -> new ObjectNotFoundExceptionPersonalized(
				"Objeto não encontrado! Id: " + pId + ", Tipo: " + Insumo.class.getName()));
	}

	public Insumo insert(Insumo obj) {

		obj.setId(null);

		Insumo objByNome = repo.findByNome(obj.getNome());

		// verifica se ja existe um objeto cadastrado com o mesmo nome
		if (objByNome == null) {
			obj = repo.save(obj);
			return obj;
		} else {
			throw new DataIntegrityExceptionPersonalized(
					"Já existe um insumo '" + objByNome.getNome() + "' cadastrado.");
		}
	}

	public Insumo update(Insumo obj) {
		Insumo newObj = findById(obj.getId());
		Insumo objByNome = repo.findByNome(obj.getNome());

		if (objByNome == null) {
			updateData(newObj, obj);
			return repo.save(newObj);
		} else {
			throw new DataIntegrityExceptionPersonalized(
					"Já existe um insumo '" + objByNome.getNome() + "' cadastrado.");
		}
	}

	private void updateData(Insumo newObj, Insumo obj) {
		newObj.setNome(obj.getNome());
		newObj.setValorCompra(obj.getValorCompra());
		newObj.setUnidadeMedida(obj.getUnidadeMedida());
		newObj.setQtdPorEmbalagem(obj.getQtdPorEmbalagem());
		newObj.setValorPorUnidade(obj.getValorPorUnidade());
		newObj.setDataAtualizacao(obj.getDataAtualizacao());
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
