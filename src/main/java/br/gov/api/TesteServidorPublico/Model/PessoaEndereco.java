package br.gov.api.TesteServidorPublico.Model;

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
@Table(name="pessoa_endereco")
public class PessoaEndereco {

	@Id
	@OneToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;

	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;

}
