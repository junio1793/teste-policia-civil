package br.gov.api.testeServidorPublic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.api.testeServidorPublic.controller.bussinesCidade.CidadeNaoExisteException;
import br.gov.api.testeServidorPublic.controller.bussinesCidade.CidadeService;
import br.gov.api.testeServidorPublic.model.Cidade;

@RestController
@RequestMapping
public class CIdadeController {
	
	@Autowired
	private CidadeService getCidadeService;
	
	
	@GetMapping("/api/cidades")
	public List<Cidade> listAllCidades(){
		 List<Cidade> result = getCidadeService.getAllCIdades();
		 return result;
	}
	
	@PostMapping("/api/salvarCidade")
	public Cidade save(@RequestBody Cidade newCidade) throws CidadeNaoExisteException {
		return getCidadeService.save(newCidade);
	}
}
