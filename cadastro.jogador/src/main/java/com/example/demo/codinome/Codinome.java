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
	
	public Codinome() {
		
	}
	
	public Codinome(DadosCadastroCodinome dados) {
		this.codinome = dados.codinome();
		this.jogador = dados.jogador();
		this.grupo = dados.grupo();
	}
	
	@ManyToOne()
	@MapsId("jogadorId")
	@JoinColumn(name="jogador_id")
	private Jogador jogador;
	
	@ManyToOne() 
	@MapsId("grupoId")
	@JoinColumn(name="grupo_id")
	private Grupo grupo;
	
	public String getId() {
		return id;
	}
	
	public Jogador getJogador() {
		return this.jogador;
	}
	
	public Grupo getGrupo() {
		return this.grupo;
	}
	
	public String getCodinome() {
		return codinome;
	}

	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}
	
	public void atualizarCodinome (DadosEscolhidosCodinome dados) {
		this.codinome = dados.codinome();
		this.jogador = dados.jogador();
		this.grupo = dados.grupo();
	}
	
}
