package com.example.demo.codinome;

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
@RequestMapping("/codinomes")
public class CodinomeController {

	@Autowired
	private CodinomeRepository repository;
	
	@GetMapping
	public List<Codinome> listar () {
		return repository.findAll();
	}
	
	@PostMapping
	@Transactional
	public void criar(@RequestBody @Valid DadosCadastroCodinome dados) {
		repository.save(new Codinome(dados));
	}
	
	@PutMapping
	@Transactional
	public void editar(@RequestBody @Valid DadosCadastroCodinome dados) {
		try {
			Optional<Codinome> codinomeOptional = repository.findById(dados.id());
			if (codinomeOptional.isPresent()) {
				Codinome codinome = codinomeOptional.get();
				codinome.setCodinome(dados.codinome());
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
