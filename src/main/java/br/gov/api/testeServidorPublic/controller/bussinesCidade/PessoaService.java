package br.gov.api.testeServidorPublic.controller.bussinesCidade;

import java.util.List;
import java.util.Optional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.api.testeServidorPublic.CidadeRepository.PessoaRepository;
import br.gov.api.testeServidorPublic.controller.bussinesCidade.exception.NomePessoaJaExistenteException;
import br.gov.api.testeServidorPublic.model.Pessoa;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> getPessoa() {
		List<Pessoa> list = pessoaRepository.findAll();
		return list;
	}

	public Pessoa getPessoaById(Long id) {
		Optional<Pessoa> seraQueTem = pessoaRepository.findById(id);
		return seraQueTem.orElseThrow(() -> new ObjectNotFoundException("id nao encontrado! id: " + id, seraQueTem));
	}

	public Pessoa newPessoa(Pessoa newPessoa) throws NomePessoaJaExistenteException {
		if (!pessoaRepository.getNomePessoa(newPessoa.getNome()).isPresent()) {
			return pessoaRepository.save(newPessoa);
		} else {
			throw new NomePessoaJaExistenteException("O nome da pessoa já existe: " + newPessoa.getNome());
		}
	}
}
