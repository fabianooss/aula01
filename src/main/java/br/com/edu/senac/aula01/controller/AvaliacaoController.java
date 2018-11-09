package br.com.edu.senac.aula01.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.senac.aula01.domain.Avaliacao;
import br.com.edu.senac.aula01.domain.Carro;
import br.com.edu.senac.aula01.repository.AvaliacaoRepository;
import br.com.edu.senac.aula01.repository.CarroRepository;

@RestController
@RequestMapping("/carro/{id}/avaliacao")
public class AvaliacaoController {
	
	
	@Autowired
	private AvaliacaoRepository repository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	
	@PostMapping
	public ResponseEntity<Long> save(@RequestBody @Valid Avaliacao avaliacao,
			@PathVariable("id") Long carroId) {
		Optional<Carro> carro = carroRepository.findById(carroId);
		if (carro.isPresent()) {	
			avaliacao.setCarro(carro.get());
			return  ResponseEntity.ok(repository.save(avaliacao).getId());
		}
		return ResponseEntity.notFound().build();
		
		
		
	}

}
