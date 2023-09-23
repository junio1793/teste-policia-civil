package br.gov.api.TesteServidorPublico.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;
import br.gov.api.TesteServidorPublico.Repository.ServidorEfetivoRepository;
import br.gov.api.TesteServidorPublico.Service.exception.ServidorEfetivoAlredyExists;
import br.gov.api.TesteServidorPublico.modelDTO.ServidorEfetivoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
		if (efetivoRepository.findByMatricula(efetivo.getMatricula()).isPresent()) {
			throw new ServidorEfetivoAlredyExists(
					"servidor ja existe no sistema! matricula -> " + efetivo.getMatricula() + efetivo.getPessoa());
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
	

}
