package com.example.demo.codinome;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
