package com.elemaxelev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.elemaxelev.domain.Insumo;
import com.elemaxelev.domain.InsumoFornecedores;
import com.elemaxelev.exceptions.services.DataIntegrityExceptionPersonalized;
import com.elemaxelev.exceptions.services.ObjectNotFoundExceptionPersonalized;
import com.elemaxelev.repositories.InsumoFornecedorRepository;
import com.elemaxelev.repositories.InsumoRepository;

@Service
public class InsumoService {

	@Autowired
	private InsumoRepository insumoRepository;

	@Autowired
	private InsumoFornecedorRepository insumoFornecedorRepository;

	public List<Insumo> findAll() {
		return insumoRepository.findAll();
	}

	public Insumo findById(Long pId) {

		Optional<Insumo> obj = insumoRepository.findById(pId);

		return obj.orElseThrow(() -> new ObjectNotFoundExceptionPersonalized(
				"Objeto não encontrado! Id: " + pId + ", Tipo: " + Insumo.class.getName()));
	}

	public Insumo insert(Insumo obj) {

		obj.setId(null);

		Insumo objByNome = insumoRepository.findByNome(obj.getNome());

		// verifica se ja existe um objeto cadastrado com o mesmo nome
		if (objByNome == null) {
			obj = insumoRepository.save(obj);

			// adiciona fornecedores do insumo a lista (somente as PKs)
			for (InsumoFornecedores ip : obj.getInsumoFornecedores()) {
				ip.setInsumo(obj);
				ip.setFornecedor(ip.getFornecedor());
			}

			if (!obj.getInsumoFornecedores().isEmpty()) {
				insumoFornecedorRepository.saveAll(obj.getInsumoFornecedores());
			}

			return obj;
		} else {
			throw new DataIntegrityExceptionPersonalized(
					"Já existe um insumo '" + objByNome.getNome() + "' cadastrado.");
		}
	}

	public Insumo update(Insumo obj) {
		Insumo newObj = findById(obj.getId());
		Insumo objByNome = insumoRepository.findByNome(obj.getNome());

		if (objByNome == null) {
			updateData(newObj, obj);
			return insumoRepository.save(newObj);
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
			insumoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExceptionPersonalized("Não é possível excluir porque há registros relacionados.");
		}
	}

}
