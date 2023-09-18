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
	private Long se_id;
	private String se_matricula;

	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

}
