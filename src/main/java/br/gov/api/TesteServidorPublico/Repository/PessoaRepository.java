package br.gov.api.TesteServidorPublico.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.api.TesteServidorPublico.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
	 Optional<Pessoa> findByNome(String nome);
	 
	 @Query("SELECT p FROM Pessoa p where p.nome = :nome")
	 List<Pessoa> acharPeloNome(@Param("nome") String nome);
}
