package com.example.demo.grupo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
