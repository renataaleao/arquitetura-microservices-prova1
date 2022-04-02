package com.prova.arqSoftware.MicroserviceCurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.prova.arqSoftware.MicroserviceCurso.model.MicroServiceCurso;

@Repository
@EnableJpaRepositories
public interface CursoRepository extends JpaRepository<MicroServiceCurso, Integer>{

}
