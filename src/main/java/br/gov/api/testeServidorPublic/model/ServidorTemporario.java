package br.gov.api.testeServidorPublic.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ServidorTemporario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long st_id;
	private Date st_admissao;
	private Date st_demissao;

	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

}
