package br.com.edu.senac.aula01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.senac.aula01.domain.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
