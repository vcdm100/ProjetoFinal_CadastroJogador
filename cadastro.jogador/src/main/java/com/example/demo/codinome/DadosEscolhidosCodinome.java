package com.example.demo.codinome;

import com.example.demo.grupo.Grupo;
import com.example.demo.jogador.Jogador;

public record DadosEscolhidosCodinome(String id, String codinome, Jogador jogador, Grupo grupo) {
	public DadosEscolhidosCodinome(Codinome codinome) {
		this(codinome.getId(), codinome.getCodinome(), codinome.getJogador(), codinome.getGrupo());
	}
}
