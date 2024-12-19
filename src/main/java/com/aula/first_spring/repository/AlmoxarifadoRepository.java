package com.aula.first_spring.repository;

import com.aula.first_spring.model.AlmoxarifadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmoxarifadoRepository extends JpaRepository<AlmoxarifadoModel, Long>{

}
