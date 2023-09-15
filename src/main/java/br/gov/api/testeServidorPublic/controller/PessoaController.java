package br.gov.api.testeServidorPublic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.api.testeServidorPublic.model.Pessoa;
import br.gov.api.testeServidorPublic.service.PessoaService;
import br.gov.api.testeServidorPublic.service.exception.PessoaException;

@RestController
@RequestMapping
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/api/pessoas")
	public List<Pessoa> getAll() {
		return pessoaService.getPessoa();
	}

	@PostMapping("/api/salvar")
	public Pessoa save(@RequestBody Pessoa newPessoa) throws PessoaException {
		return pessoaService.newPessoa(newPessoa);
	}

}