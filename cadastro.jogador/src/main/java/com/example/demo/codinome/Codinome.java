package com.example.demo.codinome;

import com.example.demo.grupo.Grupo;
import com.example.demo.jogador.Jogador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Table(name = "codinomes")
@Entity(name = "Codinome")
public class Codinome {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String codinome;
	
	@Column(insertable=false, updatable=false)
	private String jogador_id;
	
	@Column(insertable=false, updatable=false)
	private String grupo_id;
	
	public Codinome () {
		
	}
	
	@ManyToOne()
	@MapsId("jogadorId")
	@JoinColumn(name="jogador_id")
	private Jogador jogador;
	
	@ManyToOne() 
	@MapsId("grupoId")
	private Grupo grupo;
	
	public Jogador getJogador() {
		return this.jogador;
	}
	
	public Grupo getGrupo() {
		return this.grupo;
	}
	
	public String getId() {
		return id;
	}

	public String getCodinome() {
		return codinome;
	}

	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}

}
