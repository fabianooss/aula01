package br.com.edu.senac.aula01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping
	public String sayHello() {
		return "oi, tudo bem";
	}
	
	@GetMapping
	@RequestMapping("/outro")
	public String sayHello2() {
		return "olá, tudo bem";
	}

}
