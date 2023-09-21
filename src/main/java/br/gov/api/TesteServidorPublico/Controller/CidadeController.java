package br.gov.api.TesteServidorPublico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.api.TesteServidorPublico.Model.Cidade;
import br.gov.api.TesteServidorPublico.Service.CidadeService;
import br.gov.api.TesteServidorPublico.Service.exception.CidadeException;

@RestController
@RequestMapping
public class CidadeController {
	
	@Autowired
	private CidadeService getCidadeService;

	@GetMapping("/{id}")
	public Cidade findById(@PathVariable Long id) throws CidadeException {
		return getCidadeService.getById(id);
	}
	
	@GetMapping("/api/cidades")
	public List<Cidade> listAllCidades(Pageable pageable){
		 List<Cidade> result = getCidadeService.getCidades();
		 return result;
	}
	
	@PostMapping("/api/salvarCidade")
	public Cidade save(@RequestBody Cidade newCidade) throws CidadeException {
		return getCidadeService.save(newCidade);
	}
	
	@PutMapping(name="api/put/cidade")
	public Cidade updateCidade(@PathVariable Long id,@RequestBody Cidade cidade) {
		return getCidadeService.putCidade( id, cidade);
	}
}
