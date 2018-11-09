package br.com.edu.senac.aula01.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.senac.aula01.domain.Contato;
import br.com.edu.senac.aula01.repository.ContatoRepository;

@RestController
@RequestMapping("/contato")
public class ContatoController {
	
	@Autowired
	private ContatoRepository repository;
	
	@GetMapping
	public List<Contato> getContatos() {
		return repository.findAll();
	}
	
	@PostMapping
	public Long save(@RequestBody @Valid Contato contato) {
		Contato c = repository.save(contato);
		return c.getId();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contato> findById(@PathVariable("id") Long id) {
		Optional<Contato> contato = repository.findById(id);
		if (contato.isPresent()) {
			return ResponseEntity.ok(contato.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}
	
	

}
