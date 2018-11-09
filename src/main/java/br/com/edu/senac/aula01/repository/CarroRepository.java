package br.com.edu.senac.aula01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.senac.aula01.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

}
