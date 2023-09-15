package br.gov.api.testeServidorPublic.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.api.testeServidorPublic.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
	public Optional<Pessoa> getNomePessoa(String nome);
}
