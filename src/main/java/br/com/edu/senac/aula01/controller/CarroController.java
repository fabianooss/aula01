package br.com.edu.senac.aula01.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.senac.aula01.domain.Carro;
import br.com.edu.senac.aula01.repository.CarroRepository;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	
	@Autowired
	private CarroRepository repository;
	
	@PostMapping
	public Long save(@Valid @RequestBody Carro carro) {
		return repository.save(carro).getId();
	}
	
	@GetMapping
	public List<Carro> findAll() {
		return repository.findAll();
	}

}
