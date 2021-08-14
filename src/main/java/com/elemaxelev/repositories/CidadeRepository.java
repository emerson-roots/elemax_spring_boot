package com.elemaxelev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elemaxelev.domain.Cidade;

@Repository 
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
