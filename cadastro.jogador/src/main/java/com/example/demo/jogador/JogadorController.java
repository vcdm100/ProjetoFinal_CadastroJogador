package com.example.demo.jogador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/jogadores")
public class JogadorController {

	@Autowired
	private JogadorRepository repository;
	
	
	@GetMapping
	public List<DadosListagemJogador> listar() {
		return repository.findAll().stream().map(DadosListagemJogador::new).toList();
	}
	
	@PostMapping
	@Transactional
	public void criar(@RequestBody @Valid DadosCadastroJogador dados) {
		repository.save(new Jogador(dados));
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosCadastroJogador dados) {
		try {
			Optional<Jogador> jogadorOptional = repository.findById(dados.id());
			if (jogadorOptional.isPresent()) {
				Jogador jogador = jogadorOptional.get();
				jogador.setNome(dados.nome());
				jogador.setEmail(dados.email());
				jogador.setTelefone(dados.telefone());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable String id) {
		repository.deleteById(id);
	}
	
}
