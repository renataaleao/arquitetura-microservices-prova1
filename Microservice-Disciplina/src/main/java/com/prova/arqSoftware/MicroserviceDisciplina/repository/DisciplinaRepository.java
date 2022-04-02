package com.prova.arqSoftware.MicroserviceDisciplina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.prova.arqSoftware.MicroserviceDisciplina.model.MicroserviceDisciplina;

@Repository
@EnableJpaRepositories
public interface DisciplinaRepository extends JpaRepository<MicroserviceDisciplina, Integer> {

}
