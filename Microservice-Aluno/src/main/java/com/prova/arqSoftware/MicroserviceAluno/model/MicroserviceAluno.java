package com.prova.arqSoftware.MicroserviceAluno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MicroserviceAluno {
	
	@GeneratedValue
	@Id
	private int matricula;
	
	@Column(name = "name")
    private String nome;
    
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
}
