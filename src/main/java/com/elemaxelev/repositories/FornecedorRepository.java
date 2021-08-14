package com.elemaxelev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elemaxelev.domain.Fornecedor;

@Repository 
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
