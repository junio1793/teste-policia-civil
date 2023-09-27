package br.gov.api.TesteServidorPublico.Service;

import java.util.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Date;
import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;
import br.gov.api.TesteServidorPublico.Repository.PessoaRepository;
import br.gov.api.TesteServidorPublico.Repository.ServidorEfetivoRepository;
import br.gov.api.TesteServidorPublico.Service.exception.ServidorEfetivoAlredyExists;
import br.gov.api.TesteServidorPublico.modelDTO.ServidorEfetivoDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;  

@Service
public class ServidorEfetivoService {
	
	@Autowired
	private ServidorEfetivoRepository efetivoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
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
		List<ServidorEfetivo> result;
		try {
			result = efetivoRepository.listarServidorAndPessoasVinculadas(matricula);
		}catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
		}
		return null;
	}
	
	public List<ServidorEfetivo> listarServidorAndPessoasVinculadasAll(){
		return efetivoRepository.listarServidorAndPessoasVinculadasAll();
	}

	public void saveServidorEfetivo(String request) {
		
		try {
			Pessoa pessoa = new Pessoa();
			ServidorEfetivo efetivo =  new ServidorEfetivo();
			
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> map = mapper.readValue(request, HashMap.class);
			
			if(map.containsKey("id")) {
				efetivo.setId(((Integer) map.get("id")).longValue());
				efetivoRepository.save(efetivo);
			}
			
			if(map.containsKey("matricula")) {
				efetivo.setMatricula((String)map.get("matricula"));
				efetivoRepository.save(efetivo);
			}
			if(map.containsKey("pessoa")) {
				Map<String, Object> mapPessoa = (Map<String, Object>) map.get("pessoa");
				
				if(mapPessoa.containsKey("id")) {
					pessoa.setId(((Integer) map.get("id")).longValue());
					pessoaRepository.save(pessoa);
				}
				if(mapPessoa.containsKey("nome")) {
					pessoa.setNome((String)mapPessoa.get("nome"));
					pessoaRepository.save(pessoa);
				}
				
				/*
				if(mapPessoa.containsKey("dataNascimento")) {
					String dataNascimentoStr = (String) mapPessoa.get("dataNascimento");
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date dataNascimentoUtil;
				    try {
				    	
				        dataNascimentoUtil = (Date) dateFormat.parse(dataNascimentoStr);
				        java.sql.Date dataNascimentoSql = new java.sql.Date(dataNascimentoUtil.getTime());

				         pessoa.setDataNascimento(dataNascimentoSql);
				    } catch (ParseException e) {
				        e.printStackTrace();
				    }
				}
				*/
				
				if(mapPessoa.containsKey("sexo")) {
					pessoa.setSexo((String)mapPessoa.get("sexo"));
					pessoaRepository.save(pessoa);
				}
				if(mapPessoa.containsKey("pai")) {
					pessoa.setPai((String)mapPessoa.get("pai"));
					pessoaRepository.save(pessoa);
				}
				if(mapPessoa.containsKey("mae")) {
					pessoa.setMae((String)mapPessoa.get("mae"));
					pessoaRepository.save(pessoa);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
