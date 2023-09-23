package br.gov.api.TesteServidorPublico.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.gov.api.TesteServidorPublico.Model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class ConsultaPersonalidazadas {

	@PersistenceContext
	EntityManager entityManager;

	public List<Pessoa> customQueryByPessoa(String nome, String nomeDaMae) {

		StringBuilder query = new StringBuilder("SELECT p FROM Pessoa p WHERE p.nome = :nome ");
		if (nome != null) {
			query.append(" and p.mae = :nomeDaMae ");
		}

		TypedQuery<Pessoa> typedQuery = entityManager.createQuery(query.toString(), Pessoa.class);

		typedQuery.setParameter("nome", nome);

		if (nome != null) {
			typedQuery.setParameter("nomeDaMae", nomeDaMae);
		}
		return typedQuery.getResultList();
	}

}
