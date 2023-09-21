package br.gov.api.TesteServidorPublico.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ServidorEfetivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="se_matricula")
	private String matricula;

	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

}
