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
	
	@GetMapping("/ServidorAndPessoaVinculada/{matricula}")
	public ResponseEntity<List<ServidorEfetivo>> getServidorAndPessoaVinculada(@PathVariable String matricula){
		List<ServidorEfetivo> result = efetivoService.listarServidorAndPessoasVinculadas(matricula);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping("/ServidorAndPessoaVinculadaAll")
	public ResponseEntity<List<ServidorEfetivo>> getServidorAndPessoaVinculada(){
		List<ServidorEfetivo> result = efetivoService.listarServidorAndPessoasVinculadasAll();
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping("/saveServidorEfetivo")
	public ServidorEfetivo post(@RequestBody ServidorEfetivo efetivo ) throws ServidorEfetivoAlredyExists {
		return efetivoService.save(efetivo);
	}
	
	@PostMapping("/saveServidorEfetivoPessoa")
	public void postMap(@RequestBody String request) {
		efetivoService.saveServidorEfetivo(request);
	}
	
	@PutMapping("/putServidorEfetivo/{id}")
	public ServidorEfetivo put(@PathVariable Long id, @RequestBody ServidorEfetivo efetivo) {
		return efetivoService.update(id, efetivo);
	}
}
