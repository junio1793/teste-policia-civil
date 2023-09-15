package br.gov.api.testeServidorPublic.model;

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
	private String end_tipo_logradouro;
	private String end_logradouro;
	private String end_numero;
	private String pes_bairro;

	@OneToOne
	@JoinColumn(name="id_cidade")
	private Cidade cidade;
}
