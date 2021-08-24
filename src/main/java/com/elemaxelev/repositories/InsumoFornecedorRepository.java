package com.elemaxelev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elemaxelev.domain.InsumoFornecedores;

@Repository 
public interface InsumoFornecedorRepository extends JpaRepository<InsumoFornecedores, Long>{

	@Transactional
	@Modifying
	@Query( "DELETE FROM InsumoFornecedores WHERE insumo_id=:id")
	void deletarPorIdInsumo(Long id);
}
