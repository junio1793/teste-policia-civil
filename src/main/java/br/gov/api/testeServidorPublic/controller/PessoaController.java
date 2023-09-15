package br.gov.api.testeServidorPublic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.api.testeServidorPublic.controller.bussinesCidade.PessoaService;
import br.gov.api.testeServidorPublic.controller.bussinesCidade.exception.NomePessoaJaExistenteException;
import br.gov.api.testeServidorPublic.model.Pessoa;

@RestController
@RequestMapping
public class PessoaController {
	
	@Autowired
	private PessoaService  pessoaService;

	public List<Pessoa> getAll(){
		List<Pessoa> pessoa = pessoaService.getPessoa();
		return pessoaService.getPessoa();
	}
	
	public Pessoa save(@RequestBody Pessoa newPessoa) throws NomePessoaJaExistenteException {
		return pessoaService.newPessoa(newPessoa);
	}
	
}
