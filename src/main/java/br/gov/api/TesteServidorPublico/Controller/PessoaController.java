package br.gov.api.TesteServidorPublico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Service.PessoaService;
import br.gov.api.TesteServidorPublico.Service.exception.PessoaException;
import br.gov.api.TesteServidorPublico.modelDTO.PessoaDTO;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/pessoaList")
	public List<Pessoa> getAll(Pageable pageable) {
		return pessoaService.getPessoa();
	}
	
	@GetMapping("/pessoaListDTO")
	public List<PessoaDTO> getAllDTO() {
		return pessoaService.getPessoaDto();
	}
	
	@GetMapping("/getPessoa")
	public  List<PessoaDTO> getByNome(
			@RequestParam("nome") String nome,
			@RequestParam("nomedamae") String nomaDaMae,
			 HttpServletRequest request)
	{
		return pessoaService.getPessoaByNome(nome, nomaDaMae);
	}

	@PostMapping(value = "/salvar")
	public Pessoa save(@RequestBody Pessoa novaPeople) throws PessoaException {
		return pessoaService.newPessoa(novaPeople);
	}
}
