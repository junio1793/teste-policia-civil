package br.gov.api.testeServidorPublic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="pessoa_endereco")
public class PessoaEndereco {

	@EmbeddedId
	@OneToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

}
