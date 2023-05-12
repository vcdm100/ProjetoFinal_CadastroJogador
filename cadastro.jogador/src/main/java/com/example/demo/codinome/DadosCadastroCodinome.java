package com.example.demo.codinome;

import com.example.demo.grupo.Grupo;
import com.example.demo.jogador.Jogador;

public record DadosCadastroCodinome(String id, String codinome, Jogador jogador, Grupo grupo) {
	public DadosCadastroCodinome(Codinome codinome) {
		this(codinome.getId(), codinome.getCodinome(), codinome.getJogador(), codinome.getGrupo());
	}
}
