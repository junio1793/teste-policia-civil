package br.gov.api.TesteServidorPublico.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.api.TesteServidorPublico.Repository.CidadeRepository;
import br.gov.api.TesteServidorPublico.Model.Cidade;
import br.gov.api.TesteServidorPublico.Service.exception.CidadeException;
import jakarta.transaction.Transactional;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Transactional
	public List<Cidade> getCidades() {
		List<Cidade> lista = cidadeRepository.findAll();
		return lista;
	}

	@Transactional
	public Cidade getById(Long id) throws CidadeException {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if (!cidade.isPresent()) {
			throw new CidadeException("cidade nao existe! id: " + id);
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

	public Cidade putCidade(Long id, Cidade newCidade) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if (cidade.isPresent()) {
			Cidade cidadeSave = new Cidade(null, newCidade.getNome(), newCidade.getUf());
			return cidadeSave;
		}
		Cidade cidadeSave = cidadeRepository.save(newCidade);
		return cidadeSave;
	}

}
