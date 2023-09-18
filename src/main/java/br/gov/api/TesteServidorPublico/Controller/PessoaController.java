package br.gov.api.TesteServidorPublico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Service.PessoaService;
import br.gov.api.TesteServidorPublico.Service.exception.PessoaException;

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
