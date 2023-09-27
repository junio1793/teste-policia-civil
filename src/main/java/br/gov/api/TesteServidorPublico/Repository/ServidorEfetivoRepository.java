package br.gov.api.TesteServidorPublico.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;

@Repository
public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Long> {

	Optional<ServidorEfetivo> findByMatricula(String matricula);

	Optional<ServidorEfetivo> findByMatriculaAndPessoa(String matricula, Pessoa pessoa);
	
	@Query("SELECT se FROM ServidorEfetivo se "
			+ "INNER JOIN se.pessoa p "
			+ "WHERE se.matricula = :matricula")
	List<ServidorEfetivo> listarServidorAndPessoasVinculadas(@Param("matricula") String matricula);
	
	@Query("SELECT se FROM ServidorEfetivo se "
			+ "INNER JOIN se.pessoa p ")
	List<ServidorEfetivo> listarServidorAndPessoasVinculadasAll();

}
