package br.gov.api.TesteServidorPublico.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.api.TesteServidorPublico.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
	 Optional<Pessoa> findByNome(String nome);
}
