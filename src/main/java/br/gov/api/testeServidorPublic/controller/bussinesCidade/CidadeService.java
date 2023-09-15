package br.gov.api.testeServidorPublic.controller.bussinesCidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.api.testeServidorPublic.CidadeRepository.CidadeRepository;
import br.gov.api.testeServidorPublic.model.Cidade;
import jakarta.transaction.Transactional;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Transactional
	public List<Cidade> getAllCIdades() {
		List<Cidade> lista = cidadeRepository.findAll();
		return lista;
	}

	@Transactional
	public Cidade save(Cidade newCidade) throws CidadeNaoExisteException {
		if (cidadeRepository.findByNome(newCidade.getNome()).isPresent()) {
			throw new CidadeNaoExisteException("cidade ja existe");
		}
		return cidadeRepository.save(newCidade);
	}
	
}
