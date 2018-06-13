package br.com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.pojo.Pessoa;

@RepositoryRestResource(collectionResourceRel = "pessoa", path = "pessoas")
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}	
