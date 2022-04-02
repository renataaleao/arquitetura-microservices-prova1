package com.prova.arqSoftware.MicroserviceAluno.controller;

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

import com.prova.arqSoftware.MicroserviceAluno.model.MicroserviceAluno;
import com.prova.arqSoftware.MicroserviceAluno.repository.AlunoRepository;

@RestController
@RequestMapping(path="/alunos")
public class MicroserviceAlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<MicroserviceAluno> Get() {
        return alunoRepository.findAll();
    }
	
	@RequestMapping(value = "/novoaluno", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public MicroserviceAluno Post(@Validated @RequestBody MicroserviceAluno aluno)
    {
        return alunoRepository.save(aluno);
    }
	
	@RequestMapping(value = "/aluno/{id}", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<MicroserviceAluno> Put(@PathVariable(value = "id") long id, @Validated @RequestBody MicroserviceAluno newAluno)
    {
		Optional<MicroserviceAluno> oldAluno = alunoRepository.findById((int) id);
        if(oldAluno.isPresent()){
            MicroserviceAluno aluno = oldAluno.get();
            aluno.setNome(newAluno.getNome());
            alunoRepository.save(aluno);
            return new ResponseEntity<MicroserviceAluno>(aluno, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/aluno/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
		Optional<MicroserviceAluno> aluno = alunoRepository.findById((int) id);
        if(aluno.isPresent()){
            alunoRepository.delete(aluno.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}
