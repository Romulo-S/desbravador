package br.com.biblioteca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.biblioteca.pojo.Pessoa;
import br.com.biblioteca.pojo.Projeto;
import br.com.biblioteca.repository.PessoaRepository;
import br.com.biblioteca.repository.ProjetoRepository;

@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private ProjetoRepository projetoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping( value = "/projeto", method = RequestMethod.POST)
	public void addProject(@Valid @RequestBody Projeto projeto) {
			 projetoRepository.save(projeto);
	}
	
	@RequestMapping( value = "/projeto/{id}", method = RequestMethod.DELETE)
	public void removeProject(@PathVariable Long id) {
		Projeto projeto = projetoRepository.findOne(id);
			if(!projeto.getStatus().equals("iniciado") && !projeto.getStatus().equals("em andamento") && !projeto.getStatus().equals("encerrado"))
			{
				 projetoRepository.delete(id);
			}
			
	}
	
	@RequestMapping( value = "/projeto", method = RequestMethod.PUT)
	public void updateProject(@Valid @RequestBody Projeto projeto) {
			 projetoRepository.save(projeto);
	}
	
	@RequestMapping(value = "/projeto/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Projeto getProject(@PathVariable long id) {
		return projetoRepository.findOne(id);
	}
	
	@RequestMapping( value = "/projeto", method = RequestMethod.POST)
	public void addPerson(@Valid @RequestBody Pessoa pessoa) {
			 pessoaRepository.save(pessoa);
	}
	
}