package br.gov.api.testeServidorPublic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class FotoPessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fp_id;

	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
}
