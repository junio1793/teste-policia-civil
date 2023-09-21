package br.gov.api.TesteServidorPublico.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;
import br.gov.api.TesteServidorPublico.Repository.ServidorEfetivoRepository;
import br.gov.api.TesteServidorPublico.Service.exception.ServidorEfetivoException;
import jakarta.transaction.Transactional;

@Service
public class ServidorEfetivoService 
{

	@Autowired
	private ServidorEfetivoRepository efetivoRepository;
	
	@Transactional
	public ServidorEfetivo getById(Long id) 
	{
		Optional<ServidorEfetivo> efetivo = efetivoRepository.findById(id);
		return efetivo.orElseThrow(() -> new ObjectNotFoundException("id nao encontrado! id: " + id, ServidorEfetivo.class));
	}
	
	@Transactional
	public List<ServidorEfetivo> getEfetivo()
	{
		List<ServidorEfetivo> listaEfetivo = efetivoRepository.findAll();
		return listaEfetivo;
	}

	public ServidorEfetivo save(ServidorEfetivo efetivo) throws ServidorEfetivoException 
	{
		if(efetivoRepository.findByMatriculaAndPessoa(efetivo.getMatricula(),efetivo.getPessoa()).isPresent()) {
			throw new ServidorEfetivoException("servidor ja existe no sistema! matricula -> " + efetivo.getMatricula() + efetivo.getPessoa());
		}
		return efetivoRepository.save(efetivo);
	}

}
