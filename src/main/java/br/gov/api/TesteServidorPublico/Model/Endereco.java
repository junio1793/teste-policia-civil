package br.gov.api.TesteServidorPublico.Model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long end_id;
	@Column(name="end_tipo_logradouro")
	private String tipoLogradouro;
	@Column(name="end_logradouro")
	private String logradouro;
	@Column(name="end_numero")
	private String numero;
	@Column(name="end_bairro")
	private String bairro;

	@OneToOne(mappedBy = "endereco")
	private PessoaEndereco pessoaEndereco;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
}
