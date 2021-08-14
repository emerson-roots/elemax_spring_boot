package com.elemaxelev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elemaxelev.domain.Estado;

@Repository 
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
