package br.gov.api.TesteServidorPublico.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;
import br.gov.api.TesteServidorPublico.Repository.PessoaRepository;
import br.gov.api.TesteServidorPublico.Repository.ServidorEfetivoRepository;
import br.gov.api.TesteServidorPublico.Service.exception.ServidorEfetivoAlredyExists;
import br.gov.api.TesteServidorPublico.modelDTO.ServidorEfetivoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ServidorEfetivoService {
	@Autowired
	private ServidorEfetivoRepository efetivoRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public ServidorEfetivo getById(Long id) {
		Optional<ServidorEfetivo> efetivo = efetivoRepository.findById(id);
		return efetivo
				.orElseThrow(() -> new ObjectNotFoundException("id nao encontrado! id: " + id, ServidorEfetivo.class));
	}

	@Transactional
	public List<ServidorEfetivoDTO> listEfetivoDTO() {
		List<ServidorEfetivo> efetivo = efetivoRepository.findAll();
		return efetivo.stream().map(i -> new ServidorEfetivoDTO(i)).toList();
	}

	@Transactional
	public ServidorEfetivo save(ServidorEfetivo efetivo) throws ServidorEfetivoAlredyExists {
		Optional<ServidorEfetivo> existingEfetivo = efetivoRepository.findByMatricula(efetivo.getMatricula());
	    
	    if (existingEfetivo.isPresent()) {
	        throw new ServidorEfetivoAlredyExists(
	            "Servidor já existe no sistema! Matrícula -> " + efetivo.getMatricula() + ", Pessoa -> ");
	    }
	    
	    return efetivoRepository.save(efetivo);
	}

	@Transactional
	public ServidorEfetivo update(Long id, ServidorEfetivo efetivo)

	{
		Optional<ServidorEfetivo> optional = efetivoRepository.findById(id);
		if (optional.isPresent()) {
			ServidorEfetivo servidorEfetivo = new ServidorEfetivo(null, efetivo.getMatricula(), efetivo.getPessoa());
			return servidorEfetivo;
		}
		return efetivoRepository.save(efetivo);
	}
	
	public List<ServidorEfetivo> listarServidorAndPessoasVinculadas(String matricula){
		return efetivoRepository.listarServidorAndPessoasVinculadas(matricula);
	}
	
    public void salvarServidorEfetivoComPessoa() throws ServidorEfetivoAlredyExists {

    }
}
