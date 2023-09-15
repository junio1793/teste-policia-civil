package br.gov.api.testeServidorPublic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="unidade_endereco")
public class UnidadeEndereco {

	@Id
	@OneToOne
	@JoinColumn(name="unidade_id")
	private Unidade unidade;

	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
}
