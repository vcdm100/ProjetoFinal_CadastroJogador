package com.example.demo.grupo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private GrupoRepository repository;
	
	@GetMapping
	public List<Grupo> listar () {
		return repository.findAll();
	}
	
	@PostMapping
	@Transactional
	public void criar(@RequestBody @Valid DadosCadastroGrupo dados) {
		repository.save(new Grupo(dados));
	}
	
}
