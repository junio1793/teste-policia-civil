package br.gov.api.TesteServidorPublico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;
import br.gov.api.TesteServidorPublico.Service.ServidorEfetivoService;
import br.gov.api.TesteServidorPublico.Service.exception.ServidorEfetivoException;

@RestController
@RequestMapping
public class ServidorEfetivoController {

	@Autowired
	private ServidorEfetivoService efetivoService;

	@GetMapping("servidorEfetivoId/{id}")
	public ServidorEfetivo findById(@PathVariable Long id) {
		return efetivoService.getById(id);
	}

	@GetMapping("/servidorEfetivoListAll")
	public List<ServidorEfetivo> listarServidoresEfetivos() {
		return efetivoService.getEfetivo();
	}
	
	@PostMapping("/saveServidorEfetivo")
	public ServidorEfetivo save(@RequestBody ServidorEfetivo efetivo ) throws ServidorEfetivoException {
		return efetivoService.save(efetivo);
	}

}
