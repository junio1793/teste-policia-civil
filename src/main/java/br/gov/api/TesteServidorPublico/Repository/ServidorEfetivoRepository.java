package br.gov.api.TesteServidorPublico.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.api.TesteServidorPublico.Model.Pessoa;
import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;

@Repository
public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Long> {

	Optional<ServidorEfetivo> findByMatricula(String matricula);

	Optional<ServidorEfetivo> findByMatriculaAndPessoa(String matricula, Pessoa pessoa);

}
