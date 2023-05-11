package com.example.demo.jogador;

public record DadosListagemJogador(String id, String nome, String email, String telefone) {
	public DadosListagemJogador(Jogador jogador) {
		this(jogador.getId(), jogador.getNome(), jogador.getEmail(), jogador.getTelefone());
	}
}
