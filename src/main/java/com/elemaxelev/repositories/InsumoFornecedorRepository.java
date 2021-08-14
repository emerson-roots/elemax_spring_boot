package com.elemaxelev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elemaxelev.domain.InsumoFornecedor;

@Repository 
public interface InsumoFornecedorRepository extends JpaRepository<InsumoFornecedor, Long>{

}
