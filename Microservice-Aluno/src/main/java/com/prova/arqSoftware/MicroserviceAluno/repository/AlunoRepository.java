package com.prova.arqSoftware.MicroserviceAluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova.arqSoftware.MicroserviceAluno.model.MicroserviceAluno;

@Repository
public interface AlunoRepository extends JpaRepository<MicroserviceAluno, Integer> {
	
	

}
