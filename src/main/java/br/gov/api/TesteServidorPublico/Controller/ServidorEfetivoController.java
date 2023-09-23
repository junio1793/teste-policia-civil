package br.gov.api.TesteServidorPublico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;
import br.gov.api.TesteServidorPublico.Service.ServidorEfetivoService;
import br.gov.api.TesteServidorPublico.Service.exception.ServidorEfetivoAlredyExists;
import br.gov.api.TesteServidorPublico.modelDTO.ServidorEfetivoDTO;

@RestController
@RequestMapping
public class ServidorEfetivoController {

	@Autowired
	private ServidorEfetivoService efetivoService;

	@GetMapping("/servidorEfetivoId/{id}")
	public ServidorEfetivo findById(@PathVariable Long id) {
		return efetivoService.getById(id);
	}

	@GetMapping("/servidorEfetivoList")
	public List<ServidorEfetivoDTO> getMinDto() {
		return efetivoService.listEfetivoDTO();
	}
	
	@GetMapping("/ServidorAndPessoaVinculada")
	public List<ServidorEfetivo> getServidorAndPessoaVinculada(@RequestParam String matricula){
		return efetivoService.listarServidorAndPessoasVinculadas(matricula);
	}
	
	@PostMapping("/saveServidorEfetivo")
	public ServidorEfetivo post(@RequestBody ServidorEfetivo efetivo ) throws ServidorEfetivoAlredyExists {
		return efetivoService.save(efetivo);
	}
	
	@PutMapping("/putServidorEfetivo/{id}")
	public ServidorEfetivo put(@PathVariable Long id, @RequestBody ServidorEfetivo efetivo) {
		return efetivoService.update(id, efetivo);
	}
}
