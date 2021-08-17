package com.elemaxelev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elemaxelev.domain.Insumo;

@Repository 
public interface InsumoRepository extends JpaRepository<Insumo, Long>{

	Insumo findByNome(String nome);

}
