package com.prova.arqSoftware.MicroserviceCurso.controller;

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

import com.prova.arqSoftware.MicroserviceCurso.model.MicroServiceCurso;
import com.prova.arqSoftware.MicroserviceCurso.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class MicroserviceCursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<MicroServiceCurso> Get() {
        return cursoRepository.findAll();
    }
	
	@RequestMapping(value = "/novocurso", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public MicroServiceCurso Post(@Validated @RequestBody MicroServiceCurso aluno)
    {
        return cursoRepository.save(aluno);
    }
	
	@RequestMapping(value = "/{id}", method =  RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<MicroServiceCurso> Put(@PathVariable(value = "id") long id, @Validated @RequestBody MicroServiceCurso newCurso)
    {
		Optional<MicroServiceCurso> oldAluno = cursoRepository.findById((int) id);
        if(oldAluno.isPresent()){
        	MicroServiceCurso aluno = oldAluno.get();
            aluno.setNome(newCurso.getNome());
            cursoRepository.save(aluno);
            return new ResponseEntity<MicroServiceCurso>(newCurso, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces="application/json")
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
		Optional<MicroServiceCurso> aluno = cursoRepository.findById((int) id);
        if(aluno.isPresent()){
            cursoRepository.delete(aluno.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
