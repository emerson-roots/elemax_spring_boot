package com.elemaxelev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elemaxelev.domain.InsumoFornecedores;

@Repository 
public interface InsumoFornecedorRepository extends JpaRepository<InsumoFornecedores, Long>{

}
