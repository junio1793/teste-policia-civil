package br.gov.api.testeServidorPublic.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.api.testeServidorPublic.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	public Optional<Cidade> findByNome(String nome);
	
}
