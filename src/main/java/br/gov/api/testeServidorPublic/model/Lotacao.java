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
public class Lotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lot_id;
	private Date lot_data_lotacao;
	private Date lot_data_remocao;
	private String lot_portaria;

	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	@OneToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;
	
}
