package br.gov.api.TesteServidorPublico.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.api.TesteServidorPublico.DAO.ConsultaPersonalidazadas;
import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Repository.PessoaRepository;
import br.gov.api.TesteServidorPublico.Service.exception.PessoaException;
import br.gov.api.TesteServidorPublico.modelDTO.PessoaDTO;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ConsultaPersonalidazadas consultaPersonalizada;

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
		if (!pessoaRepository.findByNome(newPessoa.getNome()).isPresent()) {
			return pessoaRepository.save(newPessoa);
		} else {
			throw new PessoaException("O nome da pessoa já existe: " + newPessoa.getNome());
		}
	}
	
	@Transactional
	public List<PessoaDTO> getPessoaDto(){
		List<Pessoa> pessoa = pessoaRepository.findAll();
		return pessoa.stream().map(i -> new PessoaDTO(i)).toList();
	}
	
	public List<PessoaDTO> getPessoaByNome(String nome, String nomeDaMae){
		List<Pessoa> result = consultaPersonalizada.customQueryByPessoa(nome, nomeDaMae);
		return result.stream().map(i -> new PessoaDTO(i)).toList();
	}
}
