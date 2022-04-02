package com.prova.arqSoftware.MicroserviceDisciplina.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prova.arqSoftware.MicroserviceDisciplina.model.MicroserviceDisciplina;
import com.prova.arqSoftware.MicroserviceDisciplina.repository.DisciplinaRepository;

@RestController
@RequestMapping("/disciplinas")
public class MicroserviceDisciplinaController {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<MicroserviceDisciplina> Get() {
        return disciplinaRepository.findAll();
    }
	
	@RequestMapping(value = "/novodisciplina", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public MicroserviceDisciplina Post(@Validated @RequestBody MicroserviceDisciplina aluno)
    {
        return disciplinaRepository.save(aluno);
    }
	
	@RequestMapping(value = "/disciplina/{id}", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<MicroserviceDisciplina> Put(@PathVariable(value = "id") long id, @Validated @RequestBody MicroserviceDisciplina newDisciplina)
    {
		Optional<MicroserviceDisciplina> oldAluno = disciplinaRepository.findById((int) id);
        if(oldAluno.isPresent()){
            MicroserviceDisciplina aluno = oldAluno.get();
            aluno.setNome(newDisciplina.getNome());
            disciplinaRepository.save(aluno);
            return new ResponseEntity<MicroserviceDisciplina>(aluno, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/disciplina/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
		Optional<MicroserviceDisciplina> aluno = disciplinaRepository.findById((int) id);
        if(aluno.isPresent()){
            disciplinaRepository.delete(aluno.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
