package br.gov.api.testeServidorPublic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.api.testeServidorPublic.Repository.CidadeRepository;
import br.gov.api.testeServidorPublic.model.Cidade;
import br.gov.api.testeServidorPublic.model.Pessoa;
import br.gov.api.testeServidorPublic.service.exception.CidadeException;
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
	
	public Cidade findById(Long id) throws CidadeException {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if(!cidade.isPresent()) {
			 throw new CidadeException("cidade nao existe! id: "  + id) ;
		}
		return cidade.get();
	}

	@Transactional
	public Cidade save(Cidade newCidade) throws CidadeException {
		if (cidadeRepository.findByNome(newCidade.getNome()).isPresent()) {
			throw new CidadeException("cidade ja existe");
		}
		return cidadeRepository.save(newCidade);
	}
	
}
