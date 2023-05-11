package com.example.demo.grupo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "grupos")
@Entity(name = "Grupo")
public class Grupo {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String nome;
	
	public Grupo () {
		
	}
	
	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
