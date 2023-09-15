package br.gov.api.testeServidorPublic.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.api.testeServidorPublic.Repository.PessoaRepository;
import br.gov.api.testeServidorPublic.model.Pessoa;
import br.gov.api.testeServidorPublic.service.exception.PessoaException;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Transactional
	public List<Pessoa> getPessoa() {
		List<Pessoa> list = pessoaRepository.findAll();
		return list;
	}

	@Transactional
	public Pessoa getPessoaById(Long id) {
		Optional<Pessoa> seraQueTem = pessoaRepository.findById(id);
		return seraQueTem.orElseThrow(() -> new ObjectNotFoundException("id nao encontrado! id: " + id, seraQueTem));
	}

	@Transactional
	public Pessoa newPessoa(Pessoa newPessoa) throws PessoaException {
		if (!pessoaRepository.getNomePessoa(newPessoa.getNome()).isPresent()) {
			return pessoaRepository.save(newPessoa);
		} else {
			throw new PessoaException("O nome da pessoa já existe: " + newPessoa.getNome());
		}
	}
}
