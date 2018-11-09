package br.com.edu.senac.aula01.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.senac.aula01.domain.Marca;
import br.com.edu.senac.aula01.repository.MarcaRepository;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaRepository repository;
	
	@PostMapping
	public Long save(@Valid @RequestBody Marca marca) {
		return repository.save(marca).getId();
	}

}
